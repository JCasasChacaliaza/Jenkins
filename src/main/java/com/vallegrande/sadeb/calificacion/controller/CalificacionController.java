package com.vallegrande.sadeb.calificacion.controller;

import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import com.vallegrande.sadeb.calificacion.service.CalificacionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/calificaciones")
@CrossOrigin
@Api(value = "Calificación REST Endpoint")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<MatriculaDTO> findAll() {
        return calificacionService.findAll();
    }

    @GetMapping("/periodo/{peridlec}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MatriculaDTO> findAllByPeriodoLectivo(@PathVariable("peridlec") Integer peridlec) {
        return calificacionService.findAllByPeriodoLectivo(peridlec);
    }

    @GetMapping("/alumno/{idper}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MatriculaDTO> findAllByIdper(@PathVariable("idper") Integer idper) {
        return calificacionService.findAllByIdper(idper);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Integer> save(@RequestBody CalificacionDTO calificacionDTO) {
        return calificacionService.save(calificacionDTO);
    }

    @PutMapping("/calificacionLiteral")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> updateCalificacionLiteral(@RequestBody UpdateCalificacionLiteralDTO calificacion) {
        return calificacionService.updateCalificacionLiteral(calificacion);
    }

    @PutMapping("/conclusionDescriptiva")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> updateConclusionDescriptiva(@RequestBody UpdateConclusionDescriptiva updateConclusionDescriptiva){
        return calificacionService.updateConclusionDescriptiva(updateConclusionDescriptiva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> deleteByIdcal(@RequestParam("idcal") Integer idcal) {
        return calificacionService.deleteByIdcal(idcal);
    }
}
