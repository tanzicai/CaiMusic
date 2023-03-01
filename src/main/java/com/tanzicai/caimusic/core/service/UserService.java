package com.tanzicai.caimusic.core.service;

import com.tanzicai.caimusic.core.dto.TokenCreateRequest;
import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.dto.UserDto;

import com.tanzicai.caimusic.core.dto.UserUpdateRequest;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends  UserDetailsService {
     List<UserVo> list();

     UserDto create(UserCreateRequest userCreateRequest);


     @Override
     User loadUserByUsername(String username);

     UserDto get(String id);

     UserDto delete(String id);

     UserDto update(String id, UserUpdateRequest userUpdateRequest);

     Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

     UserDto getCurrentUser();
}
