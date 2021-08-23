package com.devco.seleccionprocesos.controller;

import com.devco.seleccionprocesos.dto.CandidatosDto;
import com.devco.seleccionprocesos.dto.InfoEtapaDto;
import com.devco.seleccionprocesos.model.ResultadoEntity;
import com.devco.seleccionprocesos.service.Implementations.CandidatosServiceImpl;
import com.devco.seleccionprocesos.service.Interfaces.EtapasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/registro/etapas")
@AllArgsConstructor
public class EtapasController {

    private EtapasService etapasService;

    @PostMapping("/save")
    public ResponseEntity<InfoEtapaDto> saveEtapa(@RequestBody InfoEtapaDto infoEtapaDto){
        System.out.println(infoEtapaDto);
        InfoEtapaDto resp = etapasService.saveEtapa(infoEtapaDto);
        try{


        if(resp != null){
            return ResponseEntity.ok(resp);
        }
        else{
            throw new Exception();
        }
        }catch(Exception exc){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ETAPA ANTERIOR NO COMPLETADA",exc);
        }
    }

    @GetMapping("/get/{idEtapa}/{idProceso}")
    public ResponseEntity<Collection<ResultadoEntity>> getEtapa(@PathVariable Long idEtapa, @PathVariable Long idProceso){
        return ResponseEntity.ok(etapasService.getEtapa(idEtapa,idProceso));
    }
}
