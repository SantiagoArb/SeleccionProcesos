package com.devco.seleccionprocesos.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "TBL_MAET_CAMPOS")
@NoArgsConstructor
public class MaestroCamposEntity {

    @Column(name = "ID_MAET_CAMPO")
    @Id
    Long idMaetCampo;
    String clave;
    String descripcion;
    @Column(name = "ID_ETAPA")
    Long idEtapa;
}
