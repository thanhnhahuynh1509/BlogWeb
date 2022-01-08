package com.htn.service;

import com.htn.dao.PostDAO;
import com.htn.dao.UserDAO;
import com.htn.models.Post;
import com.htn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostDAO postDAO;
    private final UserDAO userDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Post getPost(int id) {
        return postDAO.getPost(id);
    }

    @Override
    public List<Post> getPosts() {
        return postDAO.getPosts();
    }

    @Override
    public Post savePost(Post post, String username) {
        User user = userDAO.getUser(username);
        if(user == null)
            return null;
        return postDAO.savePost(post, user);
    }

    @Override
    public void updatePost(int id, Post post) {
        postDAO.updatePost(id, post);
    }

    @Override
    public void deletePost(int id) {
        postDAO.deletePost(id);
    }
}
