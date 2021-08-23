package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.MaestroCamposEntity;
import com.devco.seleccionprocesos.repository.MaestroCamposRepository;
import com.devco.seleccionprocesos.service.Interfaces.MaestroCamposService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MaestroCamposServiceImpl implements MaestroCamposService {

    private final MaestroCamposRepository maestroCamposRepository;

    @Override
    public Long contarCamposPorEtapa(Long idEtapa) {
        return  maestroCamposRepository.countByidEtapa(idEtapa);
    }

    @Override
    public Optional<MaestroCamposEntity> findById(Long idCampo) {
        return maestroCamposRepository.findById(idCampo);
    }
}
