package com.demo.bootcamp.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Örnek senaryo 13 h2 de yarattığımız tablonun java da bir jpa classını oluşturmak
@Entity
@Table(name="TEST")
public class TestEntity {
    @Id
    @Column(name="ID")
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(name="INFO")
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
