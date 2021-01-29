package com.vallegrande.sadeb.calificacion.util;

import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;

import java.util.List;

public class MatriculaDTOCreator {

    public static MatriculaDTO createValidMatriculaDTO(){
        return MatriculaDTO.builder()
                .codmat(1)
                .calificaciones(List.of(CalificacionDTOCreator.createValidCalificacionDto()))
                .alumno(PersonaDTOCreator.createValidPersonaDto())
                .isExported(Boolean.FALSE)
                .build();
    }
}
