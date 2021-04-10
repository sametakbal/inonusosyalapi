package com.inonusosyal.api.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "user_followers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserFollow extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "follower_id")
    private UUID followerId;
    private Boolean isAccept = false;
}
