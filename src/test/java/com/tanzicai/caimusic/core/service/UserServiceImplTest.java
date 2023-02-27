package com.tanzicai.caimusic.core.service;

import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.enums.Gender;
import com.tanzicai.caimusic.core.repository.UserRepository;
import com.tanzicai.caimusic.core.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {



    UserService service;
    UserRepository repository;
    @Test
    void list() {
        User user = new User();
        user.setUsername("tanzicai");
        user.setNcikname("test_nickname");
        user.setEnable(true);
        user.setLocked(false);
        user.setPassword("12345");
        user.setGender(Gender.MALE);
        user.setCreated_time(new Date());
        user.setUpdated_time(new Date());

        User save = repository.save(user);
    }


    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }


    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}