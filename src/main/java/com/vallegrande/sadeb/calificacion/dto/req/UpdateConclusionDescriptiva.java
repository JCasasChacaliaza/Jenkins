package com.vallegrande.sadeb.calificacion.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConclusionDescriptiva {
    private Integer idcal;
    private String conclusionDescriptiva;
}
