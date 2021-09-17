package com.demo.bootcamp.controller;

import com.demo.bootcamp.bll.PersonService;
import com.demo.bootcamp.model.Person;
import com.demo.bootcamp.model.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stereotype")
public class StereoTypeExampleController {

    //Örnek Senaryo 6 Stereotypesız Autowired kullanımı
    //@Service annatosyonu ekleyip datanın geldiğini görmek
    @Autowired
    PersonService personService;

    @PostMapping(path="/new")
    public ResponseEntity<PersonResponse> addPerson(@RequestBody Person person)
    {
        String name= personService.getPersonName();
        String name2= personService.getPersonNameById("543");
        personService.getPersonEntity(person);
        PersonResponse personResponse=new PersonResponse();
        personResponse.setResult("Kullanıcı yaratıldı"+name);
        return ResponseEntity.status(HttpStatus.OK).body(personResponse);

    }
}
