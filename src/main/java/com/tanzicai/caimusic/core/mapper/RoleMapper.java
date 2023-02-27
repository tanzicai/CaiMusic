package com.tanzicai.caimusic.core.mapper;

import com.tanzicai.caimusic.core.dto.RoleDto;
import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.entity.Role;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.RoleVo;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);

    RoleVo toVo(RoleDto roleDto);

}
