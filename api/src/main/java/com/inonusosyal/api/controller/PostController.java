package com.inonusosyal.api.controller;

import com.inonusosyal.api.entity.Dto.PostDto;
import com.inonusosyal.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/posts/"
)
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "group/{id}"
    )
    public List<PostDto> getGroupFeed(@PathVariable("id")UUID uuid){
        return postService.getGroupPostByGroupId(uuid);
    }
}
