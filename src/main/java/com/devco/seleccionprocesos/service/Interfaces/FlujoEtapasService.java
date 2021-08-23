package com.devco.seleccionprocesos.service.Interfaces;

import com.devco.seleccionprocesos.model.FlujoEtapasEntity;

import java.util.Collection;

public interface FlujoEtapasService {
    public Collection<FlujoEtapasEntity> findAll();
}
