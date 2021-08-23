package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.model.MaestroCamposEntity;
import com.devco.seleccionprocesos.repository.MaestroCamposRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MaestroCamposServiceImplTest {

    @InjectMocks
    MaestroCamposServiceImpl maestroCamposService;

    @Mock
    MaestroCamposRepository maestroCamposRepository;

    @Test
    void contarCamposPorEtapa() {
        MaestroCamposEntity maestroCamposEntity = new MaestroCamposEntity();
        maestroCamposEntity.setIdMaetCampo(1L);
        maestroCamposEntity.setClave("aspisalarial");
        maestroCamposEntity.setDescripcion("aspiracion salarial");
        maestroCamposEntity.setIdEtapa(1L);
        Mockito.when(maestroCamposRepository.countByidEtapa(Mockito.anyLong())).thenReturn(4L);
        assertEquals(4L,maestroCamposService.contarCamposPorEtapa(1L));
    }

    @Test
    void findById() {
        MaestroCamposEntity maestroCamposEntity = new MaestroCamposEntity();
        maestroCamposEntity.setIdMaetCampo(1L);
        maestroCamposEntity.setClave("aspisalarial");
        maestroCamposEntity.setDescripcion("aspiracion salarial");
        maestroCamposEntity.setIdEtapa(1L);
        Mockito.when(maestroCamposRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(maestroCamposEntity));
        assertAll(()-> assertTrue(maestroCamposService.findById(1L).isPresent()),
                ()-> assertEquals(maestroCamposEntity,maestroCamposService.findById(1L).get())
        );

    }
}