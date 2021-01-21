package com.inonusosyal.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group {
    private UUID id;
    private String groupIcon;
    private String title;
    private String description;
    private User founder;
    private Date lastUpdate;
}
