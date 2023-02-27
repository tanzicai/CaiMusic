package com.tanzicai.caimusic.core.service;

import com.tanzicai.caimusic.core.dto.UserDto;
import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.vo.UserVo;

import java.util.List;

public interface UserService {
     List<UserVo> list();
}
