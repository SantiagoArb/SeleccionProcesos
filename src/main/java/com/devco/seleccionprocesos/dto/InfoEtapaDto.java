package com.devco.seleccionprocesos.dto;

import com.devco.seleccionprocesos.model.ResultadoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class InfoEtapaDto {
    Long idCandidato;
    LocalDateTime fechaPostulacion;
    Long idProceso;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    List<ResultadoEntity> listItems;

    public InfoEtapaDto( Long idCandidato, LocalDateTime fechaPostulacion, Long idProceso, List<ResultadoEntity> listItems) {
        this.idCandidato = idCandidato;
        this.fechaPostulacion = fechaPostulacion;
        this.idProceso = idProceso;
        this.listItems = listItems;
    }
}
