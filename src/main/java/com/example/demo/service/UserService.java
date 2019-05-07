package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAllUser(); // lấy danh sách người dùng ra có kiểu là User

    void saveUser(User user); // lưu người dùng, nhận vào 1 user

    Optional<User> findUserById(Long id); // lựa chọn sửa đổi người dùng dựa theo id

    List<User> findByClassId(Long classId);

    List<User> findByEnable(Integer enable);

    void deleted(User user);





}
