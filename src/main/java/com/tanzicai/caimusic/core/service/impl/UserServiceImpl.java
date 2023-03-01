package com.tanzicai.caimusic.core.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tanzicai.caimusic.core.config.SecurityConfig;
import com.tanzicai.caimusic.core.dto.TokenCreateRequest;
import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.dto.UserUpdateRequest;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.exception.BizException;
import com.tanzicai.caimusic.core.exception.ExceptionType;
import com.tanzicai.caimusic.core.mapper.UserMapper;
import com.tanzicai.caimusic.core.repository.UserRepository;
import com.tanzicai.caimusic.core.service.UserService;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl  implements UserService {

    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;


    /**
     * 获取全部用户
     * @return List<UserVo>
     */
    @Override
    public List<UserVo> list() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList())
                .stream().map(mapper::toVo).collect(Collectors.toList());
//        return repository.findAll();
    }

    /**
     * 获取单个用户
     * @param id 用户的id
     * @return 用户Vo
     */
    @Override
    public UserDto get(String id) {
        return mapper.toDto(getById(id));
    }


    /**
     * 创建新用户
     * @param userCreateRequest 创建的用户信息
     * @return
     */
    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }



    @Override
    public UserDto delete(String id) {
        repository.delete(getById(id));
        return null;
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return mapper.toDto(repository.save(mapper.updateEntity(getById(id), userUpdateRequest)));
    }


    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (passwordEncoder.matches(user.getPassword(),tokenCreateRequest.getPassword())){
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()){
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!user.isAccountNonLocked()){
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));

    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    private User getById(String id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }



    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }



    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = loadUserByUsername(authentication.getName());
        return mapper.toDto(user);
    }

    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }
}
