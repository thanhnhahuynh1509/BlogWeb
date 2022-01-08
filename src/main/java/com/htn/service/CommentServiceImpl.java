package com.htn.service;

import com.htn.dao.CommentDAO;
import com.htn.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentDAO commentDAO;

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void addComment(Comment comment, int userId, int postId) {
        commentDAO.addComment(comment, userId, postId);
    }

    @Override
    public void deleteComment(int id) {
        commentDAO.deleteComment(id);
    }
}
