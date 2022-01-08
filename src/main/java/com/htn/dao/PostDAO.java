package com.htn.dao;

import com.htn.models.Post;
import com.htn.models.User;

import java.util.List;

public interface PostDAO {

    public Post getPost(int id);

    public List<Post> getPosts();

    public Post savePost(Post post, User user);

    public void updatePost(int id, Post post);

    public void deletePost(int id);
}
