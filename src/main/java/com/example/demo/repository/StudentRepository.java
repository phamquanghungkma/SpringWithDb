package com.example.demo.repository;


import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Student,Long> {


    /*
             CrudRepository sẽ nhận vào T( Student ) là domain class mà repository sẽ quản lý
             ID là kiểu dữ liệu của ID của domain class mà repository quản lý.
             Interface CrudRepository với ý nghĩa create, read, update, delete cho phép chúng ta thực hiện các thao tác cơ bản đến với các hệ thống data,

     */
    List<Student> findByClassId(Long classId);// lấy ra 1 list danh sách Student theo class Id
    List<Student> findByEnable(Integer enable );





}

