package com.tanzicai.caimusic.core.vo;

import com.tanzicai.caimusic.core.enums.Gender;

import java.util.List;

public class RoleVo {
    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;
}
