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
public class AsistenciaDTO implements Serializable {

//    private Integer codigoAsistencia;
    private String tipo;
    private String estado;
    private Date fecha;
    private String justificacion;
    private Integer codigoAsignacion;
    private Integer codigoMatricula;
}
