package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.ProcesoEntity;
import com.devco.seleccionprocesos.repository.ProcesoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProcesoServiceImplTest {
    @InjectMocks
    ProcesoServiceImpl procesoService;

    @Mock
    ProcesoRepository procesoRepository;

    @Test
    void saveProceso() {
        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setIdEtapa(1L);
        procesoEntity.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        procesoEntity.setIdCandidato(1L);
        procesoEntity.setIdProceso(1L);
        Mockito.when(procesoRepository.save(procesoEntity)).thenReturn(procesoEntity);
        assertEquals(procesoEntity.getIdProceso(), procesoService.saveProceso(procesoEntity));
    }

    @Test
    void getProceso() {
        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setIdEtapa(1L);
        procesoEntity.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        procesoEntity.setIdCandidato(1L);
        procesoEntity.setIdProceso(1L);
        Mockito.when(procesoRepository.getById(Mockito.anyLong())).thenReturn(procesoEntity);
        assertEquals(procesoEntity.toString(), procesoService.getProceso(1L).toString());

    }
}