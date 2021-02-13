package com.inonusosyal.api.entity;

import com.inonusosyal.api.entity.Enums.Gender;
import com.inonusosyal.api.entity.Enums.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "urole")
    private Role role;
}
