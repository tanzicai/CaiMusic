package com.tanzicai.caimusic.core.vo;

import com.tanzicai.caimusic.core.enums.Gender;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class UserVo {
    private String username;

    private String nickname;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;

}
