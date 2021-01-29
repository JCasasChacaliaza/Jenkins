package com.vallegrande.sadeb.calificacion.service;

import com.vallegrande.sadeb.calificacion.dao.CalificacionDAO;
import com.vallegrande.sadeb.calificacion.dto.req.CalificacionDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateCalificacionLiteralDTO;
import com.vallegrande.sadeb.calificacion.dto.req.UpdateConclusionDescriptiva;
import com.vallegrande.sadeb.calificacion.dto.res.MatriculaDTO;
import com.vallegrande.sadeb.calificacion.util.CalificacionDTOCreator;
import com.vallegrande.sadeb.calificacion.util.MatriculaDTOCreator;
import com.vallegrande.sadeb.calificacion.util.UpdateCalificacionLiteralDTOCreator;
import com.vallegrande.sadeb.calificacion.util.UpdateConclusionDescriptivaCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.validation.Validator;

import java.util.Collections;


@ExtendWith(SpringExtension.class)
class CalificacionServiceTest {

    @InjectMocks
    private CalificacionService calificacionService;

    @Mock
    private CalificacionDAO calificacionDAOMock;

    @Mock
    private Validator validator;

    private final MatriculaDTO matriculaDTO = MatriculaDTOCreator.createValidMatriculaDTO();
    private final CalificacionDTO calificacionDtoToBeSaved = CalificacionDTOCreator.createCalificacionDtoToBeSaved();
    private final UpdateCalificacionLiteralDTO updateCalificacionLiteralDTO = UpdateCalificacionLiteralDTOCreator.createValidUpdateCalificacionLiteralDTO();
    private final UpdateConclusionDescriptiva updateConclusionDescriptiva = UpdateConclusionDescriptivaCreator.createValidUpdateConclusionDescriptiva();

    @BeforeEach
    void setUpCalificacionDAOMock() {
        BDDMockito.when(calificacionDAOMock.findAll())
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAOMock.findAllByPeriodoLectivo(ArgumentMatchers.anyInt()))
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAOMock.save(calificacionDtoToBeSaved))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAOMock.findAllByIdper(ArgumentMatchers.anyInt()))
                .thenReturn(Flux.just(matriculaDTO));
        BDDMockito.when(calificacionDAOMock.updateCalificacionLiteral(updateCalificacionLiteralDTO))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAOMock.updateConclusionDescriptiva(updateConclusionDescriptiva))
                .thenReturn(Mono.just(1));
        BDDMockito.when(calificacionDAOMock.deleteByIdcal(1))
                .thenReturn(Mono.just(1));
    }

    @BeforeEach
    void setUpValidatorEmptyMock() {
        BDDMockito.when(validator.validate(calificacionDtoToBeSaved))
                .thenReturn(Collections.emptySet());
    }

    @Test
    @DisplayName("Listar las calificaciones de todos los alumnos matriculados")
    void findAll() {
        StepVerifier.create(calificacionService.findAll())
                .expectSubscription()
                .expectNext(matriculaDTO)
                .verifyComplete();
    }

    @Test
    @DisplayName("Listar todas las calificaciones con una periodo lectivo en específico")
    void findAllByPeriodoLectivo() {
        StepVerifier.create(calificacionService.findAllByPeriodoLectivo(1))
                .expectSubscription()
                .expectNext(matriculaDTO)
                .verifyComplete();
    }

    @Test
    @DisplayName("Listar todas las calificaciones de un alumno en específico")
    void findAllByIdper() {
        StepVerifier.create(calificacionService.findAllByIdper(1))
                .expectSubscription()
                .expectNext(matriculaDTO)
                .verifyComplete();
    }

    @Test
    @DisplayName("Guardar la calificación de un alumno")
    void save() {
        StepVerifier.create(calificacionService.save(calificacionDtoToBeSaved))
                .expectSubscription()
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Actualizar toda los campos de la calificación")
    void updateCalificacionLiteral() {
        StepVerifier.create(calificacionService.updateCalificacionLiteral(updateCalificacionLiteralDTO))
                .expectSubscription()
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Actualizar la conclusión descriptiva de una Califcación")
    void updateConclusionDescriptiva() {
        StepVerifier.create(calificacionService.updateConclusionDescriptiva(updateConclusionDescriptiva))
                .expectSubscription()
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("Eliminar la calificación de un alumno")
    void deleteByIdcal() {
        StepVerifier.create(calificacionService.deleteByIdcal(1))
                .expectSubscription()
                .expectNext(1)
                .verifyComplete();
    }
}