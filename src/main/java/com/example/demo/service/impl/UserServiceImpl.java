package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    // class này là class thực thi Service
    @Autowired
    private UserRepository userRepository; //


    @Override
    public List<User> getAllUser() { // định nghĩa hàm lấy tất cả dữ liệu

        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) { // định nghĩa hàm lưu dữ liệu người dùng
        userRepository.save(user);
    }


    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByClassId(Long classId) {
        return userRepository.findByClassId(classId);
    }

    @Override
    public List<User> findByEnable(Integer enable) {

        return userRepository.findByEnable(enable);
    }


    @Override
    public void deleted(User user) {
        user.setEnable(0);
        userRepository.save(user);

    }


}
