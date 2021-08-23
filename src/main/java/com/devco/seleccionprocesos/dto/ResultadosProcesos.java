package com.devco.seleccionprocesos.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ResultadosProcesos {
    Long idResultProceso;
    Long idProceso;
    Long idCampo;
    String respuesta;
    BigDecimal respuestaNum;
}
