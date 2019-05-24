package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<Student> getAllUser(); // lấy danh sách người dùng ra có kiểu là Student

    void saveUser(Student student); // lưu người dùng, nhận vào 1 student

    Optional<Student> findUserById(Long id); // lựa chọn sửa đổi người dùng dựa theo id

    List<Student> findByClassId(Long classId);

    List<Student> findByEnable(Integer enable);

    void deleted(Student student);





}
