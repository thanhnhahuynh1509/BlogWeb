package com.htn.dao;

import com.htn.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO{

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUser(String un) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        User user = session.createQuery("FROM User where username = :un", User.class)
                .setParameter("un", un).uniqueResult();

        if(user != null)
            user.getPostList().size();

        session.getTransaction().commit();

        return user;
    }

    @Override
    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        return user;
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        User userUpdate = session.createQuery("FROM User where username = :un", User.class)
                .setParameter("un", user.getUsername()).uniqueResult();

        userUpdate.setEmail(user.getEmail());
        userUpdate.setFullName(user.getFullName());
        userUpdate.setImage(user.getImage());

        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, id);

        session.delete(user);

        session.getTransaction().commit();
    }
}
