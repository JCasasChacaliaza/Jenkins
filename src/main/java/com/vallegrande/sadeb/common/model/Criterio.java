package com.vallegrande.sadeb.common.model;

import lombok.Data;

@Data
public class Criterio {
    private Integer codcrit;
    private String nomcrit;
    private Competencia competencia;
}
