package com.htn.controller;

import com.htn.dao.PostDAO;
import com.htn.models.Post;
import com.htn.service.PostService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("{id}")
    public String showPost(@PathVariable(name = "id") int id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }

    @RequestMapping(value = "showForm")
    public String showForm(Model model) {

        model.addAttribute("post", new Post());

        return "add-post";
    }

    @RequestMapping(value = "showFormUpdate")
    public String showFormUpdate(Model model, @RequestParam(name = "id") Integer id) {

        model.addAttribute("postUpdate", postService.getPost(id));

        return "update-post";
    }

    @RequestMapping(value = "processForm")
    public String processForm(@Valid @ModelAttribute Post post, BindingResult bindingResult, HttpSession session) {

        if(bindingResult.hasErrors())
            return "add-post";

        post.setDateTime(new Date());
        String username = session.getAttribute("username").toString();
        postService.savePost(post, username);
        return "redirect:/";
    }

    @RequestMapping(value = "processFormUpdate")
    public String processFormUpdate(@Valid @ModelAttribute("postUpdate") Post post, BindingResult bindingResult, HttpSession session) {

        if(bindingResult.hasErrors())
            return "update-post";

        post.setDateTime(new Date());
        postService.updatePost(post.getId(), post);
        return "redirect:/user/myPost";
    }

    @RequestMapping(value = "delete")
    public String processDelete(@RequestParam(name = "id") Integer id) {
        postService.deletePost(id);
        return "redirect:/user/myPost";
    }

}
