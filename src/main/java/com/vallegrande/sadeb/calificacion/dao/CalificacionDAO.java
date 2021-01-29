package com.vallegrande.sadeb.calificacion.dao;

import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Martín Alexis Samán Arata - martin.saman@vallegrande.edu.pe
 * Repositorio para el acceso a datos de las calificaciones
 */
public interface CalificacionDAO {

    /**
     * Lista las calificaciones de todos los alumnos matriculados
     *
     * @return MatriculaDTO Flux del dto de las notas
     */
    Flux<MatriculaDTO> findAll();

    /**
     * Lista todas las calificaciones con una periodo lectivo en específico
     *
     * @param peridlec Periodo Lectivo
     * @return Flux del dto de las notas
     */
    Flux<MatriculaDTO> findAllByPeriodoLectivo(Integer peridlec);

    /**
     * Lista todas las calificaciones de un alumno en específico
     * con todas las matriculas que ha tenido a lo largo de su ciclo de vida como estudiante
     *
     * @param idper Identificador del alumno
     * @return Mono del dto de las notas
     */
    Flux<MatriculaDTO> findAllByIdper(Integer idper);

    /**
     * Guarda la calificación de un alumno
     *
     * @param calificacion Datos de la calificación dada
     * @return Id generado de la calificación creada
     */
    Mono<Integer> save(CalificacionDTO calificacion);

    /**
     * Actualiza toda los campos de la calificación
     *
     * @param calificacion Datos de la calificacion que se modificará
     * @return Las filas que han sido afectadas
     */
    Mono<Integer> update(CalificacionDTO calificacion);

    /**
     * Actualiza la conclusión descriptiva de una Califcación
     * @param updateConclusionDescriptiva Nueva conclusión descriptiva
     * @return Las filas que han sido afectadas
     */
    Mono<Integer> updateConclusionDescriptiva(UpdateConclusionDescriptiva updateConclusionDescriptiva);

    /**
     * Actualiza la calificacion literal
     *
     * @param calificacionDTO Nueva calificación
     * @return Las filas que han sido afectadas
     */
    Mono<Integer> updateCalificacionLiteral(UpdateCalificacionLiteralDTO calificacionDTO);

    /**
     * Elimina la calificación de un alumno
     *
     * @param idcal Identificador de la calificación
     * @return Las filas que han sido afectadas
     */
    Mono<Integer> deleteByIdcal(Integer idcal);
}
