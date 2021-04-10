package com.inonusosyal.api.repository;

import com.inonusosyal.api.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT a FROM UserEntity a WHERE a.id IN (SELECT u.followerId FROM UserFollow u WHERE u.userId = ?1)")
    List<UserEntity> getUserFollowers(UUID id);

    @Query("SELECT a FROM UserEntity a WHERE a.id IN (SELECT u.userId FROM UserFollow u WHERE u.followerId = ?1)")
    List<UserEntity> getUserFollowed(UUID id);

    @Query("SELECT a FROM UserEntity a  WHERE a.username = ?1")
    Optional<UserEntity> getEmailByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
