package com.vallegrande.sadeb.calificacion.mapper;

import com.vallegrande.sadeb.calificacion.dto.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.dto.PersonaDTO;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.function.BiFunction;

public class MatriculaMapper {
    public static final BiFunction<Row, RowMetadata, MatriculaDTO> MAPPER_MATRICULA_DTO = (row, rowMetaData) ->
            MatriculaDTO
                    .builder()
                    .codmat(row.get("codmat", Integer.class))
                    .alumno(PersonaDTO.builder()
                            .id(row.get("idper", Integer.class))
                            .nombres(row.get("nomper", String.class))
                            .apepatper(row.get("apepatper", String.class))
                            .apematper(row.get("apematper", String.class))
                            .build())
                    .isExported(row.get("isexported", Boolean.class))
                    .calificaciones(new ArrayList<>(Collections.singletonList(
                            CalificacionDTO.builder()
                                    .idcal(row.get("idcal", Integer.class))
                                    .idcritcur(row.get("codcrit", Integer.class))
                                    .notaLiteral(row.get("notcal_litcal", String.class))
                                    .notaOrdinal(row.get("notcal_ordcal", Float.class))
                                    .peso(row.get("pescal", Float.class))
                                    .fecha(row.get("feccal", Date.class))
                                    .conclusionDescriptiva(row.get("condescal", String.class))
                                    .build()
                    )))
                    .build();

    public static final BiFunction<MatriculaDTO, MatriculaDTO, MatriculaDTO> REDUCER_MATRICULA_DTO = (one, two) -> {
        MatriculaDTO combinado = new MatriculaDTO();
        combinado.setCodmat(one.getCodmat());
        combinado.setAlumno(one.getAlumno());
        combinado.isExported(one.isExported());
        combinado.getCalificaciones().addAll(one.getCalificaciones());
        combinado.getCalificaciones().addAll(two.getCalificaciones());
        return combinado;
    };

}
