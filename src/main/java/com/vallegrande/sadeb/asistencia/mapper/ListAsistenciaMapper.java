package com.vallegrande.sadeb.asistencia.mapper;

import com.vallegrande.sadeb.asistencia.dto.ListAsistenciaDTO;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.sql.Timestamp;
import java.util.Date;
import java.util.function.BiFunction;

public class ListAsistenciaMapper {
    public static final BiFunction<Row, RowMetadata, ListAsistenciaDTO> MAPPER_LIST_ASISTENCIA_DTO = (row, rowMetaData) -> ListAsistenciaDTO.builder()
            .codigoAsistencia(row.get("CODAS", Integer.class))
            .nombre(row.get("NOMPER", String.class))
            .apellidoPaterno(row.get("APEPATPER", String.class))
            .apellidoMaterno(row.get("APEMATPER", String.class))
            .tipoAsistencia(row.get("TIPASIS", String.class))
            .estado(row.get("ESTASIS", String.class))
            .fecha(row.get("FECHASIS", Date.class))
            .justificacion(row.get("JUSTASIS", String.class))
            .build();
}
