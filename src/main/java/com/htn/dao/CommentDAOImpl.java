package com.htn.dao;

import com.htn.models.Comment;
import com.htn.models.Post;
import com.htn.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO{

    private final SessionFactory sessionFactory;

    public CommentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComment(Comment comment, int userId, int postId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        User user = session.get(User.class, userId);
        Post post = session.get(Post.class, postId);

        user.getCommentList().add(comment);
        post.getCommentList().add(comment);

        session.save(comment);

        session.getTransaction().commit();
    }

    @Override
    public void deleteComment(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        session.delete(comment);
        session.getTransaction().commit();
    }
}
