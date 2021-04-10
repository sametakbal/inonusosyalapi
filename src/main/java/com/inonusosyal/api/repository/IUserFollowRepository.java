package com.inonusosyal.api.repository;

import com.inonusosyal.api.entity.UserFollow;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface IUserFollowRepository extends CrudRepository<UserFollow, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE UserFollow a " +
            "SET a.isAccept = TRUE WHERE a.id = ?1")
    int acceptFollowRequest(UUID id);
}
