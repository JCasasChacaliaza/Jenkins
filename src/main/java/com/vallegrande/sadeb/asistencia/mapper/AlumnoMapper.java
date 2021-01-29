package com.vallegrande.sadeb.asistencia.mapper;

import com.vallegrande.sadeb.asistencia.dto.AlumnoDTO;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.util.function.BiFunction;

public class AlumnoMapper {

    public static final BiFunction<Row, RowMetadata, AlumnoDTO> MAPPER_ALUMNO_DTO = (row, rowMetaData) -> AlumnoDTO.builder()
            .codMatricula(row.get("CODMAT", Integer.class))
            .nombre(row.get("NOMPER", String.class))
            .apellidoPaterno(row.get("APEPATPER", String.class))
            .apellidoMaterno(row.get("APEMATPER", String.class))
            .build();
}
