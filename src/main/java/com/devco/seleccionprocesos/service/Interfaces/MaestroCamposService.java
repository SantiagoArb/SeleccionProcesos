package com.devco.seleccionprocesos.service.Interfaces;

import com.devco.seleccionprocesos.model.MaestroCamposEntity;

import java.util.Optional;

public interface MaestroCamposService {
    public Long contarCamposPorEtapa(Long idEtapa);
    public Optional<MaestroCamposEntity> findById(Long idCampo);
}
