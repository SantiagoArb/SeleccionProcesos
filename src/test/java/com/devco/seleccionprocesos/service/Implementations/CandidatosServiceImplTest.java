package com.devco.seleccionprocesos.service.Implementations;

import com.devco.seleccionprocesos.dto.InfoGeneralCandidato;
import com.devco.seleccionprocesos.model.CandidatosEntity;
import com.devco.seleccionprocesos.model.ProcesoEntity;
import com.devco.seleccionprocesos.repository.CandidatosRepository;
import com.devco.seleccionprocesos.service.Interfaces.ProcesoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CandidatosServiceImplTest {


    @InjectMocks
    CandidatosServiceImpl candidatosService;
    @Mock
    ProcesoServiceImpl procesoService;


    @Mock
    CandidatosRepository candidatosRepository;

    @Test
    void saveCandidato() {
        CandidatosEntity candidatosEntity = new CandidatosEntity();
        candidatosEntity.setId_candidato(1L);
        candidatosEntity.setNombres("Manzanillas");
        candidatosEntity.setApellidos("Tea");
        candidatosEntity.setTipoDocumento("CC");
        candidatosEntity.setDocumento("102047555");
        candidatosEntity.setEmail("snt@gmail.com");
        Mockito.when(candidatosRepository.save(candidatosEntity)).thenReturn(candidatosEntity);
        assertEquals(candidatosEntity.getId_candidato(), candidatosService.saveCandidato(candidatosEntity));
    }

    @Test
    void getInfoCandidato() {
        ProcesoEntity procesoEntity = new ProcesoEntity();
        procesoEntity.setIdEtapa(1L);
        procesoEntity.setFechaPostulacion(LocalDateTime.of(2021,8,5,0,0));
        procesoEntity.setIdCandidato(1L);
        procesoEntity.setIdProceso(1L);
        CandidatosEntity candidatosEntity = new CandidatosEntity();
        candidatosEntity.setId_candidato(1L);
        candidatosEntity.setNombres("Manzanillas");
        candidatosEntity.setApellidos("Tea");
        candidatosEntity.setTipoDocumento("CC");
        candidatosEntity.setDocumento("102047555");
        candidatosEntity.setEmail("snt@gmail.com");
        InfoGeneralCandidato infoGeneralCandidato = new InfoGeneralCandidato();
        infoGeneralCandidato.setCandidato(candidatosEntity);
        infoGeneralCandidato.setProceso(procesoEntity);
        Mockito.when(candidatosRepository.getById(Mockito.anyLong())).thenReturn(candidatosEntity);
        Mockito.when(procesoService.getProceso(Mockito.anyLong())).thenReturn(procesoEntity);
        assertEquals(infoGeneralCandidato.toString(), candidatosService.getInfoCandidato(1L,1L).toString());
    }

    @Test()
    void getCandidato() {

        CandidatosEntity candidatosEntity = new CandidatosEntity();
        candidatosEntity.setId_candidato(1L);
        candidatosEntity.setNombres("Manzanillas");
        candidatosEntity.setApellidos("Tea");
        candidatosEntity.setTipoDocumento("CC");
        candidatosEntity.setDocumento("102047555");
        candidatosEntity.setEmail("snt@gmail.com");
        Mockito.when(candidatosRepository.getById(1L)).thenReturn(candidatosEntity);
        assertEquals(candidatosEntity.toString(), this.candidatosService.getCandidato(1L).toString());

    }
}