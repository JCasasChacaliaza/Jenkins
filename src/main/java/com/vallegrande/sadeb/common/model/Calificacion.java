package com.vallegrande.sadeb.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    private Integer idcal;
    private Integer notaOrdinal;
    private String notaLiteral;
    private Float peso;
    private Date fecha;
    private CriterioCurso criterioCurso;
    private String conclusionDescriptiva;
}
