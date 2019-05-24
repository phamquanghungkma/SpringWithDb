package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    // class này là class thực thi Service
    @Autowired
    private StudentRepository studentRepository; //


    @Override
    public List<Student> getAllUser() { // định nghĩa hàm lấy tất cả dữ liệu

        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void saveUser(Student student) { // định nghĩa hàm lưu dữ liệu người dùng
        studentRepository.save(student);
    }


    @Override
    public Optional<Student> findUserById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findByClassId(Long classId) {
        return studentRepository.findByClassId(classId);
    }

    @Override
    public List<Student> findByEnable(Integer enable) {

        return studentRepository.findByEnable(enable);
    }


    @Override
    public void deleted(Student student) {
        student.setEnable(0);
        studentRepository.save(student);

    }


}
