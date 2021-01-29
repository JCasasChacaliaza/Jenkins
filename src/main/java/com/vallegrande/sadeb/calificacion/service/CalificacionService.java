package com.vallegrande.sadeb.calificacion.service;

import com.vallegrande.sadeb.calificacion.dao.CalificacionDAO;
import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionDAO dao;

    @Autowired
    private Validator validator;

    public Flux<MatriculaDTO> findAll() {
        return dao.findAll();
    }

    public Flux<MatriculaDTO> findAllByPeriodoLectivo(Integer peridlec) {
        return dao.findAllByPeriodoLectivo(peridlec);
    }

    public Flux<MatriculaDTO> findAllByIdper(Integer idper) {
        return dao.findAllByIdper(idper);
    }

    public Mono<Integer> save(CalificacionDTO calificacionDTO) {
        Set<ConstraintViolation<CalificacionDTO>> violations = validator.validate(calificacionDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return dao.save(calificacionDTO);
    }

    public Mono<Integer> updateCalificacionLiteral(UpdateCalificacionLiteralDTO calificacion) {
        return dao.updateCalificacionLiteral(calificacion);
    }

    public Mono<Integer> updateConclusionDescriptiva(UpdateConclusionDescriptiva updateConclusionDescriptiva){
        return dao.updateConclusionDescriptiva(updateConclusionDescriptiva);
    }

    public Mono<Integer> deleteByIdcal(Integer idcal) {
        return dao.deleteByIdcal(idcal);
    }

}
