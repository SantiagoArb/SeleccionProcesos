package com.devco.seleccionprocesos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "TBL_FLUJO_ETAPAS")
@NoArgsConstructor
public class FlujoEtapasEntity {
    @Id
    @Column(name = "ID_FLUJO_ETAPA")
    Long idFlujoEtapa;
    @Column(name = "ETAPA_INICIAL")
    Long etapaInicial;
    @Column(name = "ETAPA_SIGUIENTE")
    Long etapaSiguiente;

}
