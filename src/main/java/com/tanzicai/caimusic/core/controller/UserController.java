package com.tanzicai.caimusic.core.controller;


import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.mapper.UserMapper;
import com.tanzicai.caimusic.core.service.UserService;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    UserMapper mapper;

    @GetMapping()
    List<UserVo> list() {
        return userService.list();
    }

    @PostMapping
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest){
        return mapper.toVo(userService.create(userCreateRequest));
    }


    @Autowired
    void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
