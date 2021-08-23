package com.devco.seleccionprocesos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TBL_PROCESOS")
@NoArgsConstructor
public class ProcesoEntity {
    @Id
    @Column(name = "ID_PROCESO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProceso;
    @Column(name = "ID_CANDIDATO")
    Long idCandidato;
    @Column(name = "ETAPA_ACTUAL")
    Long idEtapa;
    @Column(name = "FECHA_POSTULACION")
    LocalDateTime fechaPostulacion;

    public ProcesoEntity(Long idProceso, Long idCandidato,Long etapaActual, LocalDateTime fechaPostulacion) {
        this.idProceso = idProceso;
        this.idCandidato = idCandidato;
        this.fechaPostulacion = fechaPostulacion;
        this.idEtapa = etapaActual;
    }
}
