package com.htn.service;

import com.htn.models.Comment;

public interface CommentService {

    public void addComment(Comment comment, int userId, int postId);

    public void deleteComment(int id);

}
