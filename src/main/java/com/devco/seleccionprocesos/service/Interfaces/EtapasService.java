package com.devco.seleccionprocesos.service.Interfaces;

import com.devco.seleccionprocesos.dto.InfoEtapaDto;
import com.devco.seleccionprocesos.model.ResultadoEntity;

import java.util.Collection;
import java.util.List;

public interface EtapasService {
    public InfoEtapaDto saveEtapa(InfoEtapaDto infoEtapaDto);
    public Collection<ResultadoEntity> getEtapa(Long idEtapa, Long idProceso);
    public boolean validarEtapaCompleta(Long idProceso, Long idEtapa, Long idCandidato);
    public boolean validarEtapaDeCampos(Long idProceso, Long idEtapaActual, List<ResultadoEntity> listCampos);
}
