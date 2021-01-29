package com.vallegrande.sadeb.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Competencia {
    private Integer idcom;
    private String nomcom;
    private String estado;
}
