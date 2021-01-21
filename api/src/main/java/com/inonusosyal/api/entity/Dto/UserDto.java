package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.Enums.Gender;
import com.inonusosyal.api.entity.Enums.Status;
import com.inonusosyal.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID id;
    private String profilePicture;
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    private Status status;
}
