package com.vallegrande.sadeb.asistencia.service;

import com.vallegrande.sadeb.asistencia.dao.AsistenciaDAOImpl;
import com.vallegrande.sadeb.asistencia.dao.IAsistenciaDAO;
import com.vallegrande.sadeb.asistencia.dto.AlumnoDTO;
import com.vallegrande.sadeb.asistencia.dto.AsistenciaDTO;
import com.vallegrande.sadeb.asistencia.dto.ListAsistenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.List;

@Service
public class AsistenciaService implements IAsistenciaDAO {

    @Autowired
    private AsistenciaDAOImpl asistenciaDAO;

    @Override
    public Flux<AlumnoDTO> findAllAlumnosByIdAsigancion(Integer idAsignacion) {
        return asistenciaDAO.findAllAlumnosByIdAsigancion(idAsignacion);
    }

    @Override
    public Flux<Integer> save(List<AsistenciaDTO> listAsistencia) {
        return asistenciaDAO.save(listAsistencia);
    }


    @Override
    public Flux<ListAsistenciaDTO> findAsistenciaByIdAsigancionAndFecha(Integer idAsignacion, String fechaAsistencia) {
        return asistenciaDAO.findAsistenciaByIdAsigancionAndFecha(idAsignacion, fechaAsistencia);
    }
}
