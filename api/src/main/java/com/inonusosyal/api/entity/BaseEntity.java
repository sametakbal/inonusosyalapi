package com.inonusosyal.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity{
    @Column(name = "created_at")
    Timestamp createdAt;
    @Column(name = "updated_at")
    Timestamp updatedAt;
    @Column(name = "deleted_at")
    Timestamp deletedAt;
}
