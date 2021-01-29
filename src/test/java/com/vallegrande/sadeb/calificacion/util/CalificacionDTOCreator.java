package com.vallegrande.sadeb.calificacion.util;

import java.util.Date;

public class CalificacionDTOCreator {

    public static com.vallegrande.sadeb.calificacion.dto.CalificacionDTO createValidCalificacionDto() {
        return com.vallegrande.sadeb.calificacion.dto.CalificacionDTO.builder()
                .idcal(1)
                .idcritcur(1)
                .notaLiteral("AD")
                .notaOrdinal(20F)
                .peso(0.9F)
                .conclusionDescriptiva("Conclusion descriptiva")
                .fecha(new Date())
                .build();
    }

    public static com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO createCalificacionDtoToBeSaved() {
        return com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO.builder()
                .asignacion(1)
                .notaLiteral("AD")
                .notaOrdinal(20F)
                .peso(0.9F)
                .conclusionDescriptiva("Conclusion descriptiva")
                .fecha(new Date())
                .criterioCurso(1)
                .build();
    }
}
