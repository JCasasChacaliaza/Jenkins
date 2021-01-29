package com.vallegrande.sadeb.calificacion.util;

import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;

public class UpdateCalificacionLiteralDTOCreator {
    public static UpdateCalificacionLiteralDTO createValidUpdateCalificacionLiteralDTO(){
        return UpdateCalificacionLiteralDTO.builder()
                .idcal(1)
                .notaLiteral("AD")
                .build();
    }
}
