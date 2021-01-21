package com.inonusosyal.api.entity.Dto;

import com.inonusosyal.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupDto {
    private UUID id;
    private String groupIcon;
    private String title;
    private String description;
    private List<User> members;
}
