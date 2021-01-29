package com.vallegrande.sadeb.calificacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionDTO implements Serializable {
    private Integer idcal;
    private Float notaOrdinal;
    private String notaLiteral;
    private Float peso;
    private Date fecha;
    private Integer idcritcur;
    private String conclusionDescriptiva;
}
