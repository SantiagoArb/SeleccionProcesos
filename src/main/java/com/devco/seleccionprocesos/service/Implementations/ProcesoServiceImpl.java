package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.ProcesoEntity;
import com.devco.seleccionprocesos.repository.ProcesoRepository;
import com.devco.seleccionprocesos.service.Interfaces.ProcesoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcesoServiceImpl implements ProcesoService {

    private final ProcesoRepository procesoRepository;

    @Override
    public Long saveProceso(ProcesoEntity procesoEntity) {
        return procesoRepository.save(procesoEntity).getIdProceso();
    }

    @Override
    public ProcesoEntity getProceso(Long idProceso) {
        return procesoRepository.getById(idProceso);
    }
}
