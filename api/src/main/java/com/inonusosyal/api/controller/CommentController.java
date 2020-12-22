package com.inonusosyal.api.controller;


import com.inonusosyal.api.entity.Dto.CommentDto;
import com.inonusosyal.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        path = "/api/comment"
)
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public List<CommentDto> get(@PathVariable("id") UUID uuid){
        return commentService.getComment(uuid);
    }
}
