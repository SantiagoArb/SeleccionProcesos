package com.devco.seleccionprocesos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "TBL_RESULTADO_PROCESO")
@NoArgsConstructor
public class ResultadoEntity {
    @Id
    @Column(name =  "ID_RESULTADO_PROCESO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idResultadoProceso;
    @Column(name = "ID_PROCESO")
    Long idProceso;
    @Column(name = "ID_MAET_CAMPO")
    Long idCampo;
    String respuesta;
    @Column(name = "RESPUESTA_NUMERICA")
    BigDecimal respuestaNumerica;
}
