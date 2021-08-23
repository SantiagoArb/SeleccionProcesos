package com.devco.seleccionprocesos.controller;

import com.devco.seleccionprocesos.dto.CandidatosDto;
import com.devco.seleccionprocesos.dto.InfoGeneralCandidato;
import com.devco.seleccionprocesos.model.CandidatosEntity;
import com.devco.seleccionprocesos.service.Implementations.CandidatosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/candidato")
@AllArgsConstructor
public class CandidatosController {

    private CandidatosServiceImpl candidatosService;

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long>saveCandidato(@RequestBody @Valid CandidatosEntity candidato){
        System.out.println(candidato);
        return ResponseEntity.ok(candidatosService.saveCandidato(candidato));
    }

    @GetMapping("info/{idCandidato}")
    public ResponseEntity<InfoGeneralCandidato>getInfoCandidato(@PathVariable Long idCandidato, @RequestParam(value = "idProceso") Long idProceso){
        return ResponseEntity.ok(candidatosService.getInfoCandidato(idCandidato,idProceso));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
