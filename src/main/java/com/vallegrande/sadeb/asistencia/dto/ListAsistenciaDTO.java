package com.vallegrande.sadeb.asistencia.dto;

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
public class ListAsistenciaDTO implements Serializable  {
    private Integer codigoAsistencia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoAsistencia;
    private String estado;
    private Date fecha;
    private String justificacion;
}
