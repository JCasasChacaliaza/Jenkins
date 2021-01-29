package com.vallegrande.sadeb.common.validator;

import com.vallegrande.sadeb.common.validator.impl.EnumValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotNull
public @interface EnumValidator {
    Class<? extends Enum<?>> enumClass();

    String message() default "invalid enum value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
