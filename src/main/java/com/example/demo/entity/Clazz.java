package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "clazz")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer idClazz;

    @Column(name = "name")
    public String nameClazz;

    public Clazz() {
    }



    public Clazz(String nameClazz) {
        this.nameClazz = nameClazz;
    }

    public Integer getIdClazz() {
        return idClazz;
    }

    public void setIdClazz(Integer idClazz) {
        this.idClazz = idClazz;
    }

    public String getNameClazz() {
        return nameClazz;
    }

    public void setNameClazz(String nameClazz) {
        this.nameClazz = nameClazz;
    }
}
