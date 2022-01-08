package com.htn.dao;

import com.htn.models.Comment;

public interface CommentDAO {

    public void addComment(Comment comment, int userId, int postId);
    public void deleteComment(int id);

}
