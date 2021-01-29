package com.vallegrande.sadeb.calificacion.util;

import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;

public class UpdateConclusionDescriptivaCreator {
    public static UpdateConclusionDescriptiva createValidUpdateConclusionDescriptiva() {
        return UpdateConclusionDescriptiva.builder()
                .idcal(1)
                .conclusionDescriptiva("Conclusion Descriptiva")
                .build();
    }
}
