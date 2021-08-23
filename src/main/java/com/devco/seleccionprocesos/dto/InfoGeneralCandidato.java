package com.devco.seleccionprocesos.dto;

import com.devco.seleccionprocesos.model.CandidatosEntity;
import com.devco.seleccionprocesos.model.ProcesoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoGeneralCandidato {

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CandidatosEntity candidato;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProcesoEntity proceso;
}
