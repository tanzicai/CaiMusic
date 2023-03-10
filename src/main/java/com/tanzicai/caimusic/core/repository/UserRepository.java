package com.tanzicai.caimusic.core.repository;

import com.tanzicai.caimusic.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();

    Optional<User> findByUsername(String id);

    @Override
    User getById(String id);

    @Override
    Page<User> findAll(Pageable pageable);
}
