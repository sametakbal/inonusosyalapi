package com.inonusosyal.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Media {
    private UUID id;
    private String name;
    private String path;
    private String type;
    private long fileSize;
}
