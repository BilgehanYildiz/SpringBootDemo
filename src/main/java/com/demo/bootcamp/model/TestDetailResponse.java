package com.demo.bootcamp.model;

import com.demo.bootcamp.model.jpa.TestEntity;

public class TestDetailResponse {

    private TestEntity testEntity;

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
    }
}
