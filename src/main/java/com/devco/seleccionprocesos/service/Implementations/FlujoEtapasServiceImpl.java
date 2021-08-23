package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.FlujoEtapasEntity;
import com.devco.seleccionprocesos.repository.FlujoEtapasRepository;
import com.devco.seleccionprocesos.service.Interfaces.FlujoEtapasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
@AllArgsConstructor
public class FlujoEtapasServiceImpl implements FlujoEtapasService {

    private final FlujoEtapasRepository flujoEtapasRepository;

    @Override
    public Collection<FlujoEtapasEntity> findAll() {
        return flujoEtapasRepository.findAll();
    }
}
