package com.devco.seleccionprocesos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "tbl_candidatos")
@NoArgsConstructor
public class CandidatosEntity {
    @Id
    @Column(name = "ID_CANDIDATO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCandidato;
    @NotBlank(message = "Este campo no puede estar vacío")
    String nombres;
    @NotBlank(message = "Este campo no puede estar vacío")
    String apellidos;
    @Column(name = "TIPO_DOCUMENTO")
    @NotBlank(message = "Este campo no puede estar vacío")
    String tipoDocumento;
    @NotBlank(message = "Este campo no puede estar vacío")
    String documento;
    @NotBlank(message = "Este campo no puede estar vacío")
    String email;

}
