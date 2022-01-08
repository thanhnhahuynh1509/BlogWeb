package com.htn.controller;

import com.htn.models.Post;
import com.htn.models.User;
import com.htn.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private final SessionFactory sessionFactory;


    public HomeController(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @RequestMapping("")
    public String showHomePage(Model model) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Post> posts = session.createQuery("FROM Post").getResultList();

        model.addAttribute("posts", posts);

        session.getTransaction().commit();

        return "home";
    }

}
