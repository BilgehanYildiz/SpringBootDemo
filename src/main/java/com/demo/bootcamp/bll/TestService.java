package com.demo.bootcamp.bll;


import com.demo.bootcamp.repository.TestRepository;
import com.demo.bootcamp.model.jpa.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public List<TestEntity> getAllTest()
    {
        return testRepository.findAll();
    }

    public TestEntity getTestDetail(int id)
    {
        Optional<TestEntity> testEntityOptional= testRepository.findById(id);
        if(testEntityOptional.isPresent())
        {
            return testEntityOptional.get();
        }
        return null;
    }

    public List<TestEntity> getCustomQuery()
    {
        List<TestEntity> testEntityOptional= testRepository.getMultiQuery(1,"a");
       return testEntityOptional;
    }

    public void Save()
    {
       TestEntity testEntity=new TestEntity();
       testEntity.setId(4);
       testEntity.setName("Bilgehan3");
       testEntity.setInfo("Bilgehan Yıldız Ing");
       testRepository.save(testEntity);

    }

    public void partialUpdate(int id)
    {
        if(id>10)
        {
            throw new IllegalArgumentException("Id sınırı aşıldı");
        }
        testRepository.updateInfo("İnfo alan Uppdate edildi",id);

    }

    @Transactional
    public void saveandupdate(int id)
    {
        Save();
        partialUpdate(id);


    }

}
