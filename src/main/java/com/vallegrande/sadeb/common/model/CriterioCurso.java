package com.vallegrande.sadeb.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioCurso {
    private Integer idcritcur;
    private Criterio criterio;
    private String estado;
}
