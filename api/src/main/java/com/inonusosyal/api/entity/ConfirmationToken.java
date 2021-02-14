package com.inonusosyal.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken extends BaseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "token", nullable = false)
    private String token;
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity userEntity;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, UserEntity userEntity) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
        this.userEntity = userEntity;
    }
}
