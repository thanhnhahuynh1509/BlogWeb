package com.htn.service;

import com.htn.models.Post;
import com.htn.models.User;

import java.util.List;

public interface PostService {

    public Post getPost(int id);

    public List<Post> getPosts();

    public Post savePost(Post post, String username);

    public void updatePost(int id, Post post);

    public void deletePost(int id);

}
