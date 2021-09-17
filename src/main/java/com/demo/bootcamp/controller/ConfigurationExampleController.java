package com.demo.bootcamp.controller;

import com.demo.bootcamp.configuration.MyConfiguration;
import com.demo.bootcamp.utils.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/configuration")
public class ConfigurationExampleController {

    //Örnek Senaryo 7 @Value kullanımı
    //application propertiesden öncelikle myvalue değerini silerek calıştıralım value apisi ile
    @Value("${myvalue}")
    private String myvalue;

    //Örnek Senaryo 8 @ConfigurationProperties kullanımı
    //Configuration Tanımı
    @Autowired
    MyConfiguration myConfiguration;

    @GetMapping(path = "/value")
    public ResponseEntity valueusage()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya"+myvalue);
    }

    @GetMapping(path = "/configuration")
    public ResponseEntity configuration()
    {
        PersonUtil personUtil=new PersonUtil();
        return ResponseEntity.status(HttpStatus.OK).body("Merhaba Dünya"+myConfiguration.getKey1()+personUtil.returnKey());
    }


}
