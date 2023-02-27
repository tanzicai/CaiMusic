package com.tanzicai.caimusic.core.controller;


import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.service.UserService;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;


  @RequestMapping("/list")
  public List<UserVo> list(){
    return  userService.list();
  }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
