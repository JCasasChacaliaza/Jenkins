package com.vallegrande.sadeb.calificacion.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PeriodoLectivoDTO implements Serializable {
    private Integer id;
    private String nombre;
}
