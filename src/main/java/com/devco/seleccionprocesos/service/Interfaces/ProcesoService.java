package com.devco.seleccionprocesos.service.Interfaces;

import com.devco.seleccionprocesos.dto.InfoGeneralCandidato;
import com.devco.seleccionprocesos.model.ProcesoEntity;

public interface ProcesoService {

    public Long saveProceso(ProcesoEntity procesoEntity);
    public ProcesoEntity getProceso(Long idProceso);
}
