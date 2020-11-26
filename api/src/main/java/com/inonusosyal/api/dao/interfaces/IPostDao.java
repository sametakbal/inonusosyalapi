package com.inonusosyal.api.dao.interfaces;

import com.inonusosyal.api.entity.Dto.PostDto;
import com.inonusosyal.api.entity.Post;

import java.util.List;
import java.util.UUID;

public interface IPostDao  extends IDao<Post>{
    public List<PostDto> getGroupPosts(UUID groupId);

}
