package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.FlujoEtapasEntity;
import com.devco.seleccionprocesos.repository.FlujoEtapasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FlujoEtapasServiceImplTest {

    @InjectMocks
    FlujoEtapasServiceImpl flujoEtapasService;

    @Mock
    FlujoEtapasRepository flujoEtapasRepository;

    @Test
    void findAll() {
        FlujoEtapasEntity flujoEtapasEntity = new FlujoEtapasEntity();
        flujoEtapasEntity.setIdFlujoEtapa(1L);
        flujoEtapasEntity.setEtapaInicial(1L);
        flujoEtapasEntity.setEtapaSiguiente(2L);
        FlujoEtapasEntity flujoEtapasEntitySig = new FlujoEtapasEntity();
        flujoEtapasEntitySig.setIdFlujoEtapa(2L);
        flujoEtapasEntitySig.setEtapaInicial(2L);
        flujoEtapasEntitySig.setEtapaSiguiente(3L);
        List<FlujoEtapasEntity> list = new ArrayList<>();
        list.add(flujoEtapasEntity);
        list.add(flujoEtapasEntitySig);
        Mockito.when(flujoEtapasRepository.findAll()).thenReturn(list);
        assertEquals(list.toString(), flujoEtapasService.findAll().toString());
    }
}