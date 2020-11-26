package com.inonusosyal.api.service;

import com.inonusosyal.api.dao.PostDao;
import com.inonusosyal.api.entity.Dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<PostDto> getGroupPostByGroupId(UUID groupUuid){
        return postDao.getGroupPosts(groupUuid);
    }
}
