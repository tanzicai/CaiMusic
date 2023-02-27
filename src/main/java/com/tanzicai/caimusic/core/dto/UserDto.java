package com.tanzicai.caimusic.core.dto;

import com.tanzicai.caimusic.core.enums.Gender;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String id;

    private String username;

    private String nickname;

    private List<RoleDto> roles;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
