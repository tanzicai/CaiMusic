package com.tanzicai.caimusic.core.mapper;

import com.tanzicai.caimusic.core.dto.UserCreateRequest;
import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.dto.UserUpdateRequest;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface UserMapper {


    UserVo toVo(UserDto userDto);


    User createEntity(UserCreateRequest userCreateRequest);

    UserDto toDto(User user);



    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
