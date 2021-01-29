package com.vallegrande.sadeb.calificacion.dto.req;

import com.vallegrande.sadeb.calificacion.dto.types.NotaLiteralType;
import com.vallegrande.sadeb.common.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCalificacionLiteralDTO implements Serializable {
    @Min(value = 1)
    private Integer idcal;

    @EnumValidator(enumClass = NotaLiteralType.class, message = "invalid literal note")
    private String notaLiteral;
}
