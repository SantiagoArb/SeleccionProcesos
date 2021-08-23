package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.dto.InfoEtapaDto;
import com.devco.seleccionprocesos.model.FlujoEtapasEntity;
import com.devco.seleccionprocesos.model.ProcesoEntity;
import com.devco.seleccionprocesos.model.ResultadoEntity;
import com.devco.seleccionprocesos.repository.ResultadoProcesoRepository;
import com.devco.seleccionprocesos.service.Interfaces.*;
import com.devco.seleccionprocesos.utils.mail.MailSenderUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtapasServiceImpl implements EtapasService {

    private final ResultadoProcesoRepository resultadoProcesoRepository;
    private final ProcesoService procesoService;
    private final MaestroCamposService maestroCamposService;
    private final FlujoEtapasService flujoEtapasService;
    private final MailSenderUtil mailSenderUtil;
    private final CandidatosService candidatosService;


    @Override
    public InfoEtapaDto saveEtapa( InfoEtapaDto infoEtapaDto) {
        Long idEtapa = null;
        Long idCandidato = null;
        if (infoEtapaDto.getIdProceso() == null){
            ProcesoEntity procesoEntity = new ProcesoEntity(infoEtapaDto.getIdProceso(),infoEtapaDto.getIdCandidato(),1L, infoEtapaDto.getFechaPostulacion());
             infoEtapaDto.setIdProceso( procesoService.saveProceso(procesoEntity));
            idCandidato = infoEtapaDto.getIdCandidato();
            idEtapa = 1L;
        }else{
            ProcesoEntity procesoEntity = procesoService.getProceso(infoEtapaDto.getIdProceso());
            idEtapa = procesoEntity.getIdEtapa();
            idCandidato = procesoEntity.getIdCandidato();
            if(!this.validarEtapaDeCampos(infoEtapaDto.getIdProceso(),idEtapa,infoEtapaDto.getListItems())){
                return null;
            }
        }
        infoEtapaDto.getListItems().forEach(result -> {
            result.setIdProceso(infoEtapaDto.getIdProceso());
        });
        InfoEtapaDto resp = new InfoEtapaDto(infoEtapaDto.getIdCandidato(), infoEtapaDto.getFechaPostulacion(),infoEtapaDto.getIdProceso(),resultadoProcesoRepository.saveAll(infoEtapaDto.getListItems()));
        this.validarEtapaCompleta(infoEtapaDto.getIdProceso(), idEtapa, idCandidato);
        return resp;
    }

    @Override
    public Collection<ResultadoEntity> getEtapa(Long idEtapa, Long idProceso) {
        return resultadoProcesoRepository.findByEtapa(idEtapa, idProceso);
    }

    @Override
    public boolean validarEtapaCompleta(Long idProceso, Long idEtapa, Long idCandidato) {
        if(maestroCamposService.contarCamposPorEtapa(idEtapa) == (new ArrayList<>(resultadoProcesoRepository.validarCamposIngresados(idProceso)).size())){
            List<FlujoEtapasEntity> listFlujoEtapas = new ArrayList<>(flujoEtapasService.findAll());
            ProcesoEntity procesoEntity = procesoService.getProceso(idProceso);
            Optional<FlujoEtapasEntity> flujoEtapasEntity = listFlujoEtapas.stream().filter(f -> f.getEtapaInicial().equals(procesoEntity.getIdEtapa())).findFirst();
            if (flujoEtapasEntity.isPresent()){
                procesoEntity.setIdEtapa(flujoEtapasEntity.get().getEtapaSiguiente());
                procesoService.saveProceso(procesoEntity);
                int etapaSiguiente = idEtapa.intValue() +1;
                mailSenderUtil.sendSimpleMessage(candidatosService.getCandidato(idCandidato).getEmail(),"Avance de Etapa", "Felicidades, acaba de avanzar a la etapa " + etapaSiguiente);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validarEtapaDeCampos(Long idProceso, Long idEtapaActual, List<ResultadoEntity> listCampos) {
        List<ResultadoEntity> list =listCampos.stream().filter(campo ->
            !idEtapaActual.equals(maestroCamposService.findById(campo.getIdCampo()).get().getIdEtapa())).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("size "+ list.size());
       if(list.size()>0){
           return false;
       }
        return true;
    }


}
