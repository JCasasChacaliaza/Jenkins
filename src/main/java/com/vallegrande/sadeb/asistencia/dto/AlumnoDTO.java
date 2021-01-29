package com.vallegrande.sadeb.asistencia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO implements Serializable {
    private Integer codMatricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
