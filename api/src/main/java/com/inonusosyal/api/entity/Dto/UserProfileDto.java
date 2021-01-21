package com.inonusosyal.api.entity.Dto;
import com.inonusosyal.api.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileDto extends UserDto {
    private List<UserDto> followers;
    private List<UserDto> following;
    private List<Group> groups;
}
