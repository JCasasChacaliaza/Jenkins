package com.vallegrande.sadeb.calificacion.dto.req;

import com.vallegrande.sadeb.calificacion.dto.types.NotaLiteralType;
import com.vallegrande.sadeb.common.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionDTO implements Serializable {
    @Min(value = 1)
    private Integer idcal;
    @Min(value = 1)
    @Max(value = 20)
    private Float notaOrdinal;
    @EnumValidator(enumClass = NotaLiteralType.class, message = "invalid literal note")
    private String notaLiteral;
    @Min(value = 0)
    @Max(value = 1)
    private Float peso;
    private Date fecha;
    @Min(value = 1)
    private Integer criterioCurso;
    @Min(value = 1)
    private Integer asignacion;
    @Min(value = 1)
    private Integer matricula;
    @Size(max = 100)
    private String conclusionDescriptiva;
}
