package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.dto.InfoEtapaDto;
import com.devco.seleccionprocesos.model.*;
import com.devco.seleccionprocesos.repository.*;
import com.devco.seleccionprocesos.service.Interfaces.FlujoEtapasService;
import com.devco.seleccionprocesos.utils.mail.MailSenderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EtapasServiceImplTest {

    @InjectMocks
    EtapasServiceImpl etapasService;

    @Mock
    ResultadoProcesoRepository resultadoProcesoRepository;

    @Mock
    MaestroCamposServiceImpl maestroCamposService;


    @Mock
    CandidatosRepository candidatosRepository;

    @Mock
    ProcesoServiceImpl procesoService;

    @Mock
    FlujoEtapasRepository flujoEtapasRepository;

    @Mock
    FlujoEtapasService flujoEtapasService;

    @Mock
    MaestroCamposRepository maestroCamposRepository;

    @InjectMocks
    MailSenderUtil mailSenderUtil;

    @Mock
    ProcesoRepository procesoRepository;

    @Mock
    MailSenderUtil emailServiceImpl;
    @Mock
    JavaMailSender javaMailSender;
    @Mock
    MimeMessage mimeMessage;

    @Test
    void saveEtapa() {
        ResultadoEntity resultadoEntity = new ResultadoEntity();
        resultadoEntity.setIdCampo(1L);
        resultadoEntity.setIdProceso(1L);
        resultadoEntity.setIdResultadoProceso(1L);
        resultadoEntity.setRespuesta("resp");
        resultadoEntity.setRespuestaNumerica(null);
        MaestroCamposEntity maestroCamposEntity = new MaestroCamposEntity();
        maestroCamposEntity.setIdMaetCampo(1L);
        maestroCamposEntity.setClave("aspisalarial");
        maestroCamposEntity.setDescripcion("aspiracion salarial");
        maestroCamposEntity.setIdEtapa(1L);

        List<ResultadoEntity> list = new ArrayList<>();
        list.add(resultadoEntity);
        list.add(resultadoEntity);
        InfoEtapaDto infoEtapaDto = new InfoEtapaDto();
        infoEtapaDto.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        infoEtapaDto.setIdCandidato(1L);
        infoEtapaDto.setIdProceso(1L);
        infoEtapaDto.setListItems(list);

        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setIdEtapa(1L);
        procesoEntity.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        procesoEntity.setIdCandidato(1L);
        procesoEntity.setIdProceso(null);
        Mockito.when(procesoService.getProceso(Mockito.anyLong())).thenReturn(procesoEntity);
//        Mockito.when(procesoRepository.save(procesoEntity)).thenReturn(procesoEntity);
        Mockito.when(resultadoProcesoRepository.saveAll(Mockito.anyList())).thenReturn(list);
//        Mockito.when(maestroCamposService.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(maestroCamposEntity));
        Mockito.when(maestroCamposService.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(maestroCamposEntity));
       // Mockito.when(etapasService.validarEtapaDeCampos(Mockito.anyLong(),Mockito.anyLong(),Mockito.anyList())).thenReturn(true);
        assertEquals(infoEtapaDto, etapasService.saveEtapa(infoEtapaDto));
    }

    @Test
    void getEtapa() {
        ResultadoEntity resultadoEntity = new ResultadoEntity();
        resultadoEntity.setIdCampo(1L);
        resultadoEntity.setIdProceso(1L);
        resultadoEntity.setIdResultadoProceso(1L);
        resultadoEntity.setRespuesta("resp");
        resultadoEntity.setRespuestaNumerica(null);

        List<ResultadoEntity> list = new ArrayList<>();
        list.add(resultadoEntity);
        list.add(resultadoEntity);
        Mockito.when(resultadoProcesoRepository.findByEtapa(1L,1L)).thenReturn(list);
        assertEquals(list.toString(), etapasService.getEtapa(1L,1L).toString());
    }

    @Test
    void validarEtapaCompleta() {
        ResultadoEntity resultadoEntity = new ResultadoEntity();
        resultadoEntity.setIdCampo(1L);
        resultadoEntity.setIdProceso(1L);
        resultadoEntity.setIdResultadoProceso(1L);
        resultadoEntity.setRespuesta("resp");
        resultadoEntity.setRespuestaNumerica(null);

        List<ResultadoEntity> list = new ArrayList<>();
        list.add(resultadoEntity);
        list.add(resultadoEntity);
        FlujoEtapasEntity flujoEtapasEntity = new FlujoEtapasEntity();
        flujoEtapasEntity.setIdFlujoEtapa(1L);
        flujoEtapasEntity.setEtapaInicial(1L);
        flujoEtapasEntity.setEtapaSiguiente(2L);
        FlujoEtapasEntity flujoEtapasEntitySig = new FlujoEtapasEntity();
        flujoEtapasEntitySig.setIdFlujoEtapa(2L);
        flujoEtapasEntitySig.setEtapaInicial(2L);
        flujoEtapasEntitySig.setEtapaSiguiente(3L);
        List<FlujoEtapasEntity> listFlujo = new ArrayList<>();
        listFlujo.add(flujoEtapasEntity);
        listFlujo.add(flujoEtapasEntitySig);

        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setIdEtapa(1L);
        procesoEntity.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        procesoEntity.setIdCandidato(1L);
        procesoEntity.setIdProceso(1L);

        CandidatosEntity candidatosEntity = new CandidatosEntity();
        candidatosEntity.setIdCandidato(1L);
        candidatosEntity.setNombres("Manzanillas");
        candidatosEntity.setApellidos("Tea");
        candidatosEntity.setTipoDocumento("CC");
        candidatosEntity.setDocumento("102047555");
        candidatosEntity.setEmail("s54545469879798789@gmail.com");

        mimeMessage = new MimeMessage((Session) null);
       // javaMailSender = Mockito.mock(JavaMailSender.class);

        MailSenderUtil mailSenderUtil = new MailSenderUtil(javaMailSender);

        Mockito.when(candidatosRepository.getById(1L)).thenReturn(candidatosEntity);

        Mockito.when(procesoService.getProceso(Mockito.anyLong())).thenReturn(procesoEntity);
        Mockito.when(flujoEtapasService.findAll()).thenReturn(listFlujo);
        Mockito.when(maestroCamposService.contarCamposPorEtapa(Mockito.anyLong())).thenReturn(2L);
        Mockito.when(resultadoProcesoRepository.validarCamposIngresados(Mockito.anyLong())).thenReturn(list);
        Mockito.when(procesoRepository.save(procesoEntity)).thenReturn(procesoEntity);
        Mockito.when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
//        Mockito.when(mailSenderUtil.sendSimpleMessage(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(true);

        assertTrue(etapasService.validarEtapaCompleta(1L,1L,1L));
    }


    @Test
    void validarEtapaDeCampos() {
        ResultadoEntity resultadoEntity = new ResultadoEntity();
        resultadoEntity.setIdCampo(1L);
        resultadoEntity.setIdProceso(1L);
        resultadoEntity.setIdResultadoProceso(1L);
        resultadoEntity.setRespuesta("resp");
        resultadoEntity.setRespuestaNumerica(null);

        List<ResultadoEntity> list = new ArrayList<>();
        list.add(resultadoEntity);
        //list.add(resultadoEntity);

        MaestroCamposEntity maestroCamposEntity = new MaestroCamposEntity();
        maestroCamposEntity.setIdMaetCampo(1L);
        maestroCamposEntity.setClave("aspisalarial");
        maestroCamposEntity.setDescripcion("aspiracion salarial");
        maestroCamposEntity.setIdEtapa(1L);
        Mockito.when(maestroCamposService.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(maestroCamposEntity));
        Mockito.when(maestroCamposService.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(maestroCamposEntity));
        Mockito.when(etapasService.validarEtapaDeCampos(Mockito.anyLong(), Mockito.anyLong(),Mockito.any())).thenReturn(true);
        assertTrue(etapasService.validarEtapaDeCampos(1L,1L, list));
    }
}