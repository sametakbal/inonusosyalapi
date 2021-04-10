package com.inonusosyal.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity{

    @Column(name = "created_at")
    @JsonIgnore
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    @JsonIgnore
    LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    @JsonIgnore
    LocalDateTime deletedAt;
}
