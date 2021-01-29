package com.vallegrande.sadeb.asistencia.dao;

import com.vallegrande.sadeb.asistencia.dto.AlumnoDTO;
import com.vallegrande.sadeb.asistencia.dto.AsistenciaDTO;
import com.vallegrande.sadeb.asistencia.dto.ListAsistenciaDTO;
import com.vallegrande.sadeb.asistencia.mapper.AlumnoMapper;
import com.vallegrande.sadeb.asistencia.mapper.ListAsistenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AsistenciaDAOImpl implements IAsistenciaDAO {

    @Autowired
    private DatabaseClient databaseClient;


    @Override
    public Flux<AlumnoDTO> findAllAlumnosByIdAsigancion(Integer idAsignacion) {
        return databaseClient
                .sql("SELECT\n" +
                        "    m.codmat,\n" +
                        "    p.nomper,\n" +
                        "    p.apepatper,\n" +
                        "    p.apematper\n" +
                        "FROM asignacion\n" +
                        "INNER JOIN aula a\n" +
                        "    on asignacion.idaul = a.idaul\n" +
                        "INNER JOIN matricula m\n" +
                        "    on a.idaul = m.aula_idaul\n" +
                        "INNER JOIN usuario u\n" +
                        "    on u.idusu = m.idusuestmat\n" +
                        "INNER JOIN persona p\n" +
                        "    on p.idper = u.idper\n" +
                        "WHERE idasig = :idasig")
                .bind("idasig", idAsignacion)
                .map(AlumnoMapper.MAPPER_ALUMNO_DTO)
                .all();

    }

    @Override
    public Flux<Integer> save(List<AsistenciaDTO> listAsistencia) {
        List<Mono<Integer>> idsCreated = new ArrayList<>();
        listAsistencia.forEach(asistencia -> {
            Mono<Integer> insert = databaseClient
                    .sql("insert into asistencia" +
                            "(tipasis, estasis, fechasis, justasis, idasig, codmat)" +
                            "values" +
                            "(:tipasis, :estasis, :fechasis, :justasis, :idasig, :codmat)")
                    .filter((statement, executeFunction) -> statement
                            .returnGeneratedValues("codas")
                            .execute()
                    )
                    .bind("tipasis", asistencia.getTipo())
                    .bind("estasis", asistencia.getEstado())
                    .bind("fechasis", asistencia.getFecha())
                    .bind("justasis", asistencia.getJustificacion())
                    .bind("idasig", asistencia.getCodigoAsignacion())
                    .bind("codmat", asistencia.getCodigoMatricula())
                    .fetch()
                    .first()
                    .map(stringObjectMap -> (Integer) stringObjectMap.get("codas"));
            idsCreated.add(insert);
        });
        return Flux.concat(idsCreated);
    }


    @Override
    public Flux<ListAsistenciaDTO> findAsistenciaByIdAsigancionAndFecha(Integer idAsignacion, String fechaAsistencia) {
        System.out.println("FECHA ASISTENCIA : " + "'" + fechaAsistencia + "'");
        return databaseClient
                .sql("select\n" +
                        "   a.CODAS,\n" +
                        "   P.nomper,\n" +
                        "   p.apepatper,\n" +
                        "   p.apematper,\n" +
                        "   a.TIPASIS,\n" +
                        "   a.ESTASIS,\n" +
                        "   a.FECHASIS,\n" +
                        "   a.JUSTASIS\n" +
                        "from asistencia a\n" +
                        "INNER JOIN matricula m on a.codmat = m.codmat\n" +
                        "INNER JOIN usuario u on m.idusuestmat = u.idusu\n" +
                        "INNER JOIN persona p on u.idper = p.idper\n" +
                        "WHERE A.idasig = :idasig AND date(a.fechasis) = date(:fechaAsistencia)")
                .bind("idasig", idAsignacion)
                .bind("fechaAsistencia", fechaAsistencia)
                .map(ListAsistenciaMapper.MAPPER_LIST_ASISTENCIA_DTO)
                .all();
    }
}
