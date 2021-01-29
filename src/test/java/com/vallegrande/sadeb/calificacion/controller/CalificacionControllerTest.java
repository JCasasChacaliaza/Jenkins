package com.vallegrande.sadeb.calificacion.controller;

import com.vallegrande.sadeb.calificacion.dao.CalificacionDAO;
import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.service.CalificacionService;
import com.vallegrande.sadeb.calificacion.util.CalificacionDTOCreator;
import com.vallegrande.sadeb.calificacion.util.MatriculaDTOCreator;
import com.vallegrande.sadeb.calificacion.util.UpdateCalificacionLiteralDTOCreator;
import com.vallegrande.sadeb.calificacion.util.UpdateConclusionDescriptivaCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CalificacionController.class)
@Import(CalificacionService.class)
class CalificacionControllerTest {

    @MockBean
    private CalificacionDAO calificacionDAO;

    @Autowired
    private WebTestClient webClient;

    private final String URL_BASE = "/v1/calificaciones";

    private final MatriculaDTO matriculaDTO = MatriculaDTOCreator.createValidMatriculaDTO();
    private final CalificacionDTO calificacionDtoToBeSaved = CalificacionDTOCreator.createCalificacionDtoToBeSaved();
    private final UpdateCalificacionLiteralDTO updateCalificacionLiteralDTO = UpdateCalificacionLiteralDTOCreator.createValidUpdateCalificacionLiteralDTO();
    private final UpdateConclusionDescriptiva updateConclusionDescriptiva = UpdateConclusionDescriptivaCreator.createValidUpdateConclusionDescriptiva();

    @BeforeEach
    void setUpCalificacionDAOMock() {
        BDDMockito.when(calificacionDAO.findAll())
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAO.findAllByPeriodoLectivo(1))
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAO.findAllByIdper(1))
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAO.save(calificacionDtoToBeSaved))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAO.updateCalificacionLiteral(updateCalificacionLiteralDTO))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAO.updateConclusionDescriptiva(updateConclusionDescriptiva))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAO.deleteByIdcal(1))
                .thenReturn(Mono.just(1));
    }

    @Test
    void findAll() {
        webClient.get()
                .uri(URL_BASE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MatriculaDTO.class);
        verify(calificacionDAO, times(1)).findAll();
    }

    @Test
    void findAllByPeriodoLectivo() {
        webClient.get()
                .uri(URL_BASE + "/periodo/" + 1)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MatriculaDTO.class);
        verify(calificacionDAO, times(1)).findAllByPeriodoLectivo(1);
    }

    @Test
    void findAllByIdper() {
        webClient.get()
                .uri(URL_BASE + "/alumno/" + 1)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MatriculaDTO.class);
        verify(calificacionDAO, times(1)).findAllByIdper(1);
    }

    @Test
    void save() {
        webClient.post()
                .uri(URL_BASE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(calificacionDtoToBeSaved))
                .exchange()
                .expectStatus().isCreated()
                .expectBody().json("1");
        verify(calificacionDAO, times(1)).save(calificacionDtoToBeSaved);
    }

    @Test
    void updateCalificacionLiteral() {
        webClient.put()
                .uri(URL_BASE + "/calificacionLiteral")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(updateCalificacionLiteralDTO))
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("1");
        verify(calificacionDAO, times(1)).updateCalificacionLiteral(updateCalificacionLiteralDTO);

    }

    @Test
    void updateConclusionDescriptiva() {
        webClient.put()
                .uri(URL_BASE + "/conclusionDescriptiva")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(updateConclusionDescriptiva))
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("1");
        verify(calificacionDAO, times(1)).updateConclusionDescriptiva(updateConclusionDescriptiva);

    }

    @Test
    void deleteByIdcal() {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path(URL_BASE)
                        .queryParam("idcal", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("1");
        verify(calificacionDAO, times(1)).deleteByIdcal(1);

    }
}