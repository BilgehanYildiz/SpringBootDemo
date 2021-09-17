package com.demo.bootcamp.controller;

import com.demo.bootcamp.model.Person;
import com.demo.bootcamp.model.PersonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/person")
public class PersonController {

  //Örnek Senaryo 3
@PostMapping(path="/new")
    public ResponseEntity<PersonResponse> addPerson(@RequestBody Person person)
    {


    PersonResponse personResponse=new PersonResponse();
    personResponse.setResult("Kullanıcı yaratıldı");
    return ResponseEntity.status(HttpStatus.OK).body(personResponse);

    }

    //Örnek Senaryo 4
    @PostMapping(path="/new/validation")
    public ResponseEntity<PersonResponse> addPerson2(@Valid @RequestBody Person person)
    {
        /*
        if(person.getEmail()!="xx")
        {
            throw new IllegalArgumentException("Hata oluştu");
        }*/

        PersonResponse personResponse=new PersonResponse();
        personResponse.setResult("Kullanıcı yaratıldı");
        return ResponseEntity.status(HttpStatus.OK).body(personResponse);

    }
}
