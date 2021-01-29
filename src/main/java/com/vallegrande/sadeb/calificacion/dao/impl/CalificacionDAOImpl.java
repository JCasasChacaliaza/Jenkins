package com.vallegrande.sadeb.calificacion.dao.impl;

import com.vallegrande.sadeb.calificacion.dao.CalificacionDAO;
import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import com.vallegrande.sadeb.calificacion.mapper.MatriculaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CalificacionDAOImpl implements CalificacionDAO {

    @Autowired
    private DatabaseClient connection;

    @Override
    public Flux<MatriculaDTO> findAll() {
        return connection
                .sql("SELECT calificacion.codmat, " +
                        "       matricula.isexported, " +
                        "       alumno.idper, " +
                        "       alumno.nomper, " +
                        "       alumno.apepatper, " +
                        "       alumno.apematper, " +
                        "       calificacion.idcal, " +
                        "       calificacion.codmat, " +
                        "       calificacion.pescal, " +
                        "       criterio_curso.codcrit, " +
                        "       calificacion.feccal, " +
                        "       calificacion.notcal_litcal, " +
                        "       calificacion.notcal_ordcal, " +
                        "       calificacion.condescal " +
                        "FROM calificacion " +
                        "         INNER JOIN matricula ON " +
                        "    calificacion.codmat = matricula.codmat " +
                        "         INNER JOIN usuario ON matricula.idusuestmat = usuario.idusu" +
                        "         INNER JOIN persona as alumno ON " +
                        "    usuario.idper = alumno.idper " +
                        "         INNER JOIN criterio_curso ON " +
                        "    calificacion.idcritcur = criterio_curso.idcritcur ")
                .map(MatriculaMapper.MAPPER_MATRICULA_DTO)
                .all()
                .groupBy(MatriculaDTO::getCodmat)
                .flatMap(integerMatriculaDTOGroupedFlux -> integerMatriculaDTOGroupedFlux.reduce(MatriculaMapper.REDUCER_MATRICULA_DTO));
    }

    @Override
    public Flux<MatriculaDTO> findAllByPeriodoLectivo(Integer peridlec) {
        return connection
                .sql("SELECT calificacion.codmat, " +
                        "       matricula.isexported, " +
                        "       alumno.idper, " +
                        "       alumno.nomper, " +
                        "       alumno.apepatper, " +
                        "       alumno.apematper, " +
                        "       calificacion.idcal, " +
                        "       calificacion.codmat, " +
                        "       calificacion.pescal, " +
                        "       criterio_curso.codcrit, " +
                        "       calificacion.feccal, " +
                        "       calificacion.notcal_litcal, " +
                        "       calificacion.notcal_ordcal, " +
                        "       calificacion.condescal " +
                        "FROM calificacion " +
                        "         INNER JOIN matricula ON " +
                        "    calificacion.codmat = matricula.codmat " +
                        "         INNER JOIN usuario ON matricula.idusuestmat = usuario.idusu" +
                        "         INNER JOIN persona as alumno ON " +
                        "    usuario.idper = alumno.idper " +
                        "         INNER JOIN criterio_curso ON " +
                        "    calificacion.idcritcur = criterio_curso.idcritcur " +
                        "WHERE matricula.peridlec = :peridlec")
                .bind("peridlec", peridlec)
                .map(MatriculaMapper.MAPPER_MATRICULA_DTO)
                .all()
                .groupBy(MatriculaDTO::getCodmat)
                .flatMap(integerMatriculaDTOGroupedFlux -> integerMatriculaDTOGroupedFlux.reduce(MatriculaMapper.REDUCER_MATRICULA_DTO));
    }

    public Flux<MatriculaDTO> findAllByIdper(Integer idper) {
        return connection
                .sql("SELECT calificacion.codmat, " +
                        "       matricula.isexported, " +
                        "       alumno.idper, " +
                        "       alumno.nomper, " +
                        "       alumno.apepatper, " +
                        "       alumno.apematper, " +
                        "       calificacion.idcal, " +
                        "       calificacion.codmat, " +
                        "       calificacion.pescal, " +
                        "       criterio_curso.codcrit, " +
                        "       calificacion.feccal, " +
                        "       calificacion.notcal_litcal, " +
                        "       calificacion.notcal_ordcal, " +
                        "       calificacion.condescal " +
                        "FROM calificacion " +
                        "         INNER JOIN matricula ON " +
                        "    calificacion.codmat = matricula.codmat " +
                        "         INNER JOIN usuario ON matricula.idusuestmat = usuario.idusu" +
                        "         INNER JOIN persona as alumno ON " +
                        "    usuario.idper = alumno.idper " +
                        "         INNER JOIN criterio_curso ON " +
                        "    calificacion.idcritcur = criterio_curso.idcritcur " +
                        "WHERE alumno.idper = :idper")
                .bind("idper", idper)
                .map(MatriculaMapper.MAPPER_MATRICULA_DTO)
                .all()
                .groupBy(MatriculaDTO::getCodmat)
                .flatMap(integerMatriculaDTOGroupedFlux -> integerMatriculaDTOGroupedFlux.reduce(MatriculaMapper.REDUCER_MATRICULA_DTO));
    }

    @Override
    public Mono<Integer> save(CalificacionDTO calificacion) {
        return connection
                .sql("insert into calificacion " +
                        "(notcal_ordcal, notcal_litcal, pescal, feccal, idasig, idcritcur, codmat, condescal) " +
                        "VALUES " +
                        "(:notcal_ordcal, :notcal_litcal, :pescal, :feccal, :idasig, :idcritcur, :codmat, :condescal)")
                .filter((statement, executeFunction) -> statement
                        .returnGeneratedValues("idcal")
                        .execute()
                )
                .bind("notcal_ordcal", calificacion.getNotaOrdinal())
                .bind("notcal_litcal", calificacion.getNotaLiteral())
                .bind("pescal", calificacion.getPeso())
                .bind("feccal", calificacion.getFecha())
                .bind("idasig", calificacion.getAsignacion())
                .bind("idcritcur", calificacion.getCriterioCurso())
                .bind("codmat", calificacion.getMatricula())
                .bind("condescal", calificacion.getConclusionDescriptiva())
                .fetch()
                .first()
                .map(stringObjectMap -> (Integer) stringObjectMap.get("idcal"));
    }

    @Override
    public Mono<Integer> update(CalificacionDTO calificacion) {
        return connection
                .sql("UPDATE calificacion SET " +
                        "notcal_ordcal=:notcal_ordcal, notcal_litcal=:notcal_litcal, pescal=:pescal, feccal=:feccal, " +
                        "idasig=:idasig, idcritcur=:idcritcur, codmat=:codmat, condescal=:condescal " +
                        "WHERE idcal=:idcal")
                .bind("notcal_ordcal", calificacion.getNotaOrdinal())
                .bind("notcal_litcal", calificacion.getNotaLiteral())
                .bind("pescal", calificacion.getPeso())
                .bind("feccal", calificacion.getFecha())
                .bind("idasig", calificacion.getAsignacion())
                .bind("idcritcur", calificacion.getCriterioCurso())
                .bind("codmat", calificacion.getMatricula())
                .bind("condescal", calificacion.getConclusionDescriptiva())
                .bind("idcal", calificacion.getIdcal())
                .fetch()
                .rowsUpdated();
    }

    @Override
    public Mono<Integer> updateConclusionDescriptiva(UpdateConclusionDescriptiva updateConclusionDescriptiva) {
        return connection.sql("UPDATE calificacion set condescal=:condescal WHERE idcal=:idcal")
                .bind("condescal", updateConclusionDescriptiva.getConclusionDescriptiva())
                .bind("idcal", updateConclusionDescriptiva.getIdcal())
                .fetch()
                .rowsUpdated();
    }

    @Override
    public Mono<Integer> updateCalificacionLiteral(UpdateCalificacionLiteralDTO calificacionDTO) {
        return connection
                .sql("UPDATE calificacion SET notcal_litcal=:notcal_litcal, feccal=CURRENT_DATE WHERE idcal=:idcal")
                .bind("notcal_litcal", calificacionDTO.getNotaLiteral())
                .bind("idcal", calificacionDTO.getIdcal())
                .fetch()
                .rowsUpdated();
    }

    @Override
    public Mono<Integer> deleteByIdcal(Integer idcal) {
        return connection
                .sql("DELETE FROM calificacion WHERE idcal=:idcal")
                .bind("idcal", idcal)
                .fetch()
                .rowsUpdated();
    }
}
