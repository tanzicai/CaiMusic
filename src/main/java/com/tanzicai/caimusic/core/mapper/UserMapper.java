package com.tanzicai.caimusic.core.mapper;

import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto USerToDto(User user);

    UserVo USerToVo(User user);



}
