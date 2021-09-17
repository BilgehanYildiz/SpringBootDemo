package com.demo.bootcamp.controller;

import com.demo.bootcamp.bll.TestService;
import com.demo.bootcamp.model.TestDetailResponse;
import com.demo.bootcamp.model.TestListResponse;
import com.demo.bootcamp.model.jpa.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/repository")
public class RepositoryExampleController {

    /* Soru cevap örneği
    @Autowired
    TestRepository testRepository;

    @GetMapping(path="all")
    public ResponseEntity<TestListResponse> getAllTest()
    {
        List<TestEntity> testEntities=testRepository.findAll();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(testEntities);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }*/

    @Autowired
    TestService testService;

    //Örnek senaryo 15 ilk sorgu A örneği

    @GetMapping(path="all")
    public ResponseEntity<TestListResponse> getAllTest()
    {
        List<TestEntity> testEntities=testService.getAllTest();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(testEntities);
         return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Örnek senaryo 15 ilk sorgu B örneği
    @GetMapping(path="{id}")
    public ResponseEntity<TestDetailResponse> getById(@PathVariable int id)
    {
       TestEntity entity=testService.getTestDetail(id);
        TestDetailResponse response=new TestDetailResponse();
        response.setTestEntity(entity);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Örnek senaryo 16 custom query
    @GetMapping(path="customquery")
    public ResponseEntity<TestListResponse> getByMultiParam()
    {
        List<TestEntity> entity=testService.getCustomQuery();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(entity);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //Örnek senaryo 17 native query
    @GetMapping(path="allnative")
    public ResponseEntity<TestListResponse> getAllNativeQuery()
    {
        List<TestEntity> testEntities=testService.getAllTest();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(testEntities);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

   //Örnek senaryo 18 Save ve Partial Update
    @GetMapping(path="save")
    public ResponseEntity<TestListResponse> save()
    {
        //testService.Save();
        testService.partialUpdate(1);
        List<TestEntity> testEntities=testService.getAllTest();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(testEntities);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path="savewithtransaction/{id}")
    public ResponseEntity<TestListResponse> savewithtransaction(@PathVariable int id)
    {
        testService.saveandupdate(id);
        List<TestEntity> testEntities=testService.getAllTest();
        TestListResponse response=new TestListResponse();
        response.setTestEntities(testEntities);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
