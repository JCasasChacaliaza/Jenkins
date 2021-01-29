package com.vallegrande.sadeb.asistencia.controller;

import com.vallegrande.sadeb.asistencia.dao.IAsistenciaDAO;
import com.vallegrande.sadeb.asistencia.dto.AlumnoDTO;
import com.vallegrande.sadeb.asistencia.dto.AsistenciaDTO;
import com.vallegrande.sadeb.asistencia.dto.ListAsistenciaDTO;
import com.vallegrande.sadeb.asistencia.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/alumnos")
    public ResponseEntity<Flux<AlumnoDTO>> findAllAlumnosByIdAsigancion(@RequestParam Integer idAsignacion) {
        return new ResponseEntity<Flux<AlumnoDTO>>(asistenciaService.findAllAlumnosByIdAsigancion(idAsignacion), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Integer> save(@RequestBody List<AsistenciaDTO> listAsistencia){
        return asistenciaService.save(listAsistencia);
    }

    @GetMapping
    public ResponseEntity<Flux<ListAsistenciaDTO>> findAsistenciaByIdAsigancionAndFecha(@RequestParam Integer idAsignacion, @RequestParam String fechaAsistencia) {
        return new ResponseEntity<Flux<ListAsistenciaDTO>>(asistenciaService.findAsistenciaByIdAsigancionAndFecha(idAsignacion, fechaAsistencia), HttpStatus.OK);
    }
}
