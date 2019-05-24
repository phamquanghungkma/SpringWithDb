package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private   Long id;

        @Column(name = "name")
         private String name;

    public User() {
    }

    @Column(name = "email")
         private String email;

        @Column(name = "phone")
        private String phone;

        @Column(name = "enable")
        public int enable =1;

        @Column(name = "class_id")
        private Long classId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}

