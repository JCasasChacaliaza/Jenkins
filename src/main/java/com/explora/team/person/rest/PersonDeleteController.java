package com.explora.team.person.rest;

import com.explora.team.person.aplication.PersonDeleter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonDeleteController {

    PersonDeleter personDeleter;

    PersonDeleteController(PersonDeleter personDeleter) {
        this.personDeleter = personDeleter;
    }

    @DeleteMapping("/{idPerson}")
    public ResponseEntity delete(@PathVariable int idPerson){
        personDeleter.delete(idPerson);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
