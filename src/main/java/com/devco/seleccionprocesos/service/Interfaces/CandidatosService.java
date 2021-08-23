package com.devco.seleccionprocesos.service.Interfaces;

import com.devco.seleccionprocesos.dto.CandidatosDto;
import com.devco.seleccionprocesos.dto.InfoGeneralCandidato;
import com.devco.seleccionprocesos.model.CandidatosEntity;
import org.springframework.stereotype.Service;

public interface CandidatosService {
    public Long saveCandidato(CandidatosEntity candidatosDto);
    public InfoGeneralCandidato getInfoCandidato(Long idCandidato, Long idProceso);
    public CandidatosEntity getCandidato(Long idCandidato);
}
