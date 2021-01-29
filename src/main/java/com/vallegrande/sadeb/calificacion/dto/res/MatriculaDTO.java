package com.vallegrande.sadeb.calificacion.dto.res;

import com.vallegrande.sadeb.calificacion.dto.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.PersonaDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO implements Serializable {
    @ApiModelProperty(notes = "Identificador de la matricula")
    private Integer codmat;
    @ApiModelProperty(notes = "Alumno")
    private PersonaDTO alumno;
    @Getter
    @Accessors(fluent = true)
    @ApiModelProperty(notes = "Ha sido exportado")
    private Boolean isExported;
    @ApiModelProperty(notes = "Notas de la matricula")
    private List<CalificacionDTO> calificaciones = new ArrayList<>();
}
