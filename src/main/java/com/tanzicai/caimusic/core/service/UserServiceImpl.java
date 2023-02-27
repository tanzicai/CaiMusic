package com.tanzicai.caimusic.core.service;


import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.mapper.UserMapper;
import com.tanzicai.caimusic.core.repository.UserRepository;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    UserRepository repository;

    UserMapper mapper;


    @Override
    public List<UserVo> list() {
        return repository.findAll().stream().map(mapper::USerToVo).collect(Collectors.toList());
//        return repository.findAll();
    }


    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
