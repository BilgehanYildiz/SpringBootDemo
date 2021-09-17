package com.demo.bootcamp.bll;

import com.demo.bootcamp.model.Person;
import com.demo.bootcamp.model.PersonResponse;
import org.springframework.stereotype.Service;

//Örnek Senaryo 6 Stereotypesız Autowired kullanımı
//@Service annatosyonu kaldılıp alınan hata gözürülmesi

@Service
public class PersonService {

    public String getPersonName()
    {
        return "Bilgehan";
    }

    public String getPersonNameById(String Id)
    {
        return "Bilgehan by Id";
    }

    public PersonResponse getPersonEntity(Person person)
    {

        PersonResponse personResponse=new PersonResponse();
        personResponse.setResult("dönüş sağlandı");
        return personResponse;
    }
}
