package com.example.azdigitalumbrellacbarintegration.dao.repository;

import com.example.azdigitalumbrellacbarintegration.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
