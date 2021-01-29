package com.vallegrande.sadeb.calificacion.util;

import com.vallegrande.sadeb.calificacion.dto.PersonaDTO;

public class PersonaDTOCreator {
    public static PersonaDTO createValidPersonaDto(){
        return PersonaDTO.builder()
                .id(1)
                .apepatper("SAMÁN")
                .apematper("ARATA")
                .nombres("Martin Alexis")
                .build();
    }
}
