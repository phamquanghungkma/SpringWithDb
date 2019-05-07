package com.example.demo.service.impl;

import com.example.demo.entity.Clazz;
import com.example.demo.entity.User;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.service.ClazzSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzServiceImpl implements ClazzSerivce {
    @Autowired
    private ClazzRepository clazzRepository;
    @Override
    public List<Clazz> getAllClazz() {
        return (List<Clazz>) clazzRepository.findAll();
    }



}
