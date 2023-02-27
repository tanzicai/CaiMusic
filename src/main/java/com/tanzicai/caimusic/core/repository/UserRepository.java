package com.tanzicai.caimusic.core.repository;

import com.tanzicai.caimusic.core.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();

    List<User> findUserById(String id);
}
