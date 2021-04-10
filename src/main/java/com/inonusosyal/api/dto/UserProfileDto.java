package com.inonusosyal.api.dto;

import com.inonusosyal.api.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private UserEntity user;
    private List<UserEntity> followers;
    private List<UserEntity> followed;
}
