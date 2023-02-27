package com.tanzicai.caimusic.core.repository;

import com.tanzicai.caimusic.core.entity.User;
import com.tanzicai.caimusic.core.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername() {

        User user = new User();
        user.setUsername("tanzicai");
        user.setNickname("test_nickname");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("12345");
        user.setGender(Gender.MALE);
        user.setCreated_time(new Date());
        user.setUpdated_time(new Date());

//        User save = repository.save(user);
        System.out.println(repository.findAll().toString());
//        User result = repository.getUserByUsername("tanzicai");
//        System.out.println(result.toString());
    }
}