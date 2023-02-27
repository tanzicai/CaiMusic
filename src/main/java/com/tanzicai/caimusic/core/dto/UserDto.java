package com.tanzicai.caimusic.core.dto;

import com.tanzicai.caimusic.core.enums.Gender;

import java.util.Date;
import java.util.List;

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
