package com.vallegrande.sadeb.asistencia.dao;

import com.vallegrande.sadeb.asistencia.dto.AlumnoDTO;
import com.vallegrande.sadeb.asistencia.dto.AsistenciaDTO;
import com.vallegrande.sadeb.asistencia.dto.ListAsistenciaDTO;
import reactor.core.publisher.Flux;
import java.util.List;

public interface IAsistenciaDAO {

    Flux<AlumnoDTO> findAllAlumnosByIdAsigancion(Integer idAsignacion);

    Flux<Integer> save(List<AsistenciaDTO> listAsistencia);

    Flux<ListAsistenciaDTO> findAsistenciaByIdAsigancionAndFecha(Integer idAsignacion, String fechaAsistencia);
}
