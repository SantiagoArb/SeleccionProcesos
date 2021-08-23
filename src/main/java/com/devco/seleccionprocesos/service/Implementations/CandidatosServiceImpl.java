package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.dto.CandidatosDto;
import com.devco.seleccionprocesos.dto.InfoGeneralCandidato;
import com.devco.seleccionprocesos.model.CandidatosEntity;
import com.devco.seleccionprocesos.repository.CandidatosRepository;
import com.devco.seleccionprocesos.service.Interfaces.CandidatosService;
import com.devco.seleccionprocesos.service.Interfaces.ProcesoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidatosServiceImpl implements CandidatosService {

    private final CandidatosRepository repository;
    private final ProcesoService procesoService;


    @Override
    public Long saveCandidato(CandidatosEntity candidatosEntity) {
        return repository.save(candidatosEntity).getId_candidato();
    }

    @Override
    public InfoGeneralCandidato getInfoCandidato(Long idCandidato, Long idProceso) {
        return new InfoGeneralCandidato(repository.getById(idCandidato),procesoService.getProceso(idProceso));
    }

    @Override
    public CandidatosEntity getCandidato(Long idCandidato) {
        return repository.getById(idCandidato);
    }
}
