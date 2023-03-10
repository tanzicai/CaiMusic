package com.tanzicai.caimusic.core.controller;


import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.dto.UserSearchFilter;
import com.tanzicai.caimusic.core.dto.UserUpdateRequest;
import com.tanzicai.caimusic.core.mapper.UserMapper;
import com.tanzicai.caimusic.core.service.UserService;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    UserMapper mapper;

    @GetMapping()
    Page<UserVo> search(@PageableDefault(sort = {"createdTime"},direction = Sort.Direction.ASC)Pageable pageable) {
        return userService.search(pageable).map(mapper::toVo);
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id){
        return mapper.toVo(userService.get(id));
    }

    @PostMapping
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest){
        return mapper.toVo(userService.create(userCreateRequest));
    }

    @DeleteMapping("/{id}")
    UserVo delete(@PathVariable String id){
        return mapper.toVo(userService.delete(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id,@Validated UserUpdateRequest userUpdateRequest){
        return mapper.toVo(userService.update(id, userUpdateRequest));
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
