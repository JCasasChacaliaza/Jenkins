package com.vallegrande.sadeb.common.exception;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GlobalExceptionMessage implements Serializable {
    private String timestamp;
    private String error;
    private Integer status;
    private String exception;
    private String message;
}
