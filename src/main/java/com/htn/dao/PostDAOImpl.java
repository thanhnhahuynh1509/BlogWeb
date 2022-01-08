package com.htn.dao;

import com.htn.models.Post;
import com.htn.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO{

    private final SessionFactory sessionFactory;

    public PostDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Post getPost(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Post post = session.get(Post.class, id);
        post.getCommentList().size();

        session.getTransaction().commit();
        return post;
    }

    @Override
    public List<Post> getPosts() {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();


        session.getTransaction().commit();
        return null;
    }

    @Override
    public Post savePost(Post post, User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        post.setUser(user);

        session.save(post);

        session.getTransaction().commit();
        return post;
    }

    @Override
    public void updatePost(int id, Post post) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        Post postUpdate = session.get(Post.class, id);

        postUpdate.setImage(post.getImage());
        postUpdate.setContent(post.getContent());
        postUpdate.setDesc(post.getDesc());
        postUpdate.setReadMinutes(post.getReadMinutes());
        postUpdate.setTitle(post.getTitle());

        session.getTransaction().commit();
    }

    @Override
    public void deletePost(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Post post = session.get(Post.class, id);

        session.delete(post);

        session.getTransaction().commit();
    }
}
