package com.inonusosyal.api.controller;

import com.inonusosyal.api.entity.Group;
import com.inonusosyal.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/group"
)
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(
        path = "user/{id}"
    )
    public List<Group> fetchUserGroup(@PathVariable("id")UUID uuid){
        return groupService.getUserGroupByUuid(uuid);
    }

}
