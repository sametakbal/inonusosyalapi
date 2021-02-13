package com.inonusosyal.api.repository;

import com.inonusosyal.api.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, UUID> {

    @Query("SELECT u FROM UserEntity u WHERE u.email =:email ")
    UserEntity findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserEntity u WHERE u.username =:username ")
    UserEntity findByUsername(@Param("username") String username);
}
