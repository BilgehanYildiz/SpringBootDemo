package com.demo.bootcamp.repository;

import com.demo.bootcamp.model.jpa.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//Örnek senaryo 14ilk repositorymizi oluşturalım
@Repository
public interface TestRepository  extends JpaRepository<TestEntity,Integer>, JpaSpecificationExecutor {

    //Örnek senaryo 16 custom query
    @Query("SELECT t FROM TestEntity t WHERE t.id=:id and t.name like %:name%")
    public List<TestEntity> getMultiQuery(@Param("id") int id,@Param("name") String name);

    //Örnek senaryo 17 native query
    @Query(value = "SELECT * FROM Test t",nativeQuery = true)
    public List<TestEntity> getNativeQuery();

    //Örnek senaryo 18 update
    @Modifying
    @Transactional
    @Query(value = "Update TestEntity set info=:info  where id=:id ")
    public void updateInfo(@Param("info")String name,@Param("id") int id);
}
