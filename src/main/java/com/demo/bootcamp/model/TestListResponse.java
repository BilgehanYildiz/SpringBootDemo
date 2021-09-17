package com.demo.bootcamp.model;

import com.demo.bootcamp.model.jpa.TestEntity;

import java.util.List;

public class TestListResponse {
    private List<TestEntity> testEntities;

    public List<TestEntity> getTestEntities() {
        return testEntities;
    }

    public void setTestEntities(List<TestEntity> testEntities) {
        this.testEntities = testEntities;
    }
}
