package com.tanzicai.caimusic.core.service;

import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.dto.UserDto;

import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends  UserDetailsService {
     List<UserVo> list();

     UserDto create(UserCreateRequest userCreateRequest);

     @Override
     User loadUserByUsername(String username);
}
