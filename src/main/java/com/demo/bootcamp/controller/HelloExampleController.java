package com.demo.bootcamp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Senaryo 2 İlk apilerimizi oluşturalım

@RestController
@RequestMapping("api/example")
public class HelloExampleController {
    @GetMapping(path = "/hello")
    public ResponseEntity helloworld()
    {

        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya");
    }

    @RequestMapping(path = "/hello2",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity helloworld2()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya 2");
    }


    //örnek pathvariable kullanımı

    @GetMapping(path = "/hello/{name}")
    public ResponseEntity helloworld(@PathVariable String name)
    {
        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya"+name);
    }

    /*örnek pathvariable kullanımı aynı anda path variable kullanımı
    @GetMapping(path = "/hello/{id}")
    public ResponseEntity helloworld(@PathVariable int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya"+id);
    }*/
}
