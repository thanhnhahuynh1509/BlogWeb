package com.htn.controller;

import com.htn.models.User;
import com.htn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("myPost")
    public String showPosts(Model model, HttpSession session) {

        String username = session.getAttribute("username").toString();
        User user = userService.getUser(username);

        model.addAttribute("user", user);

        return "user-post";
    }

    @RequestMapping("myInfo")
    public String showFormInfo(Model model, HttpSession session) {
        String username = session.getAttribute("username").toString();
        User user = userService.getUser(username);

        model.addAttribute("userUpdate", user);

        return "user-info";
    }

    @RequestMapping("processUpdate")
    public String processFormUpdateUser(@Valid @ModelAttribute("userUpdate") User user, BindingResult bindingResult) {
        System.out.println("User id: " + user.getId());

        if(bindingResult.hasErrors())
            return "user-info";
        userService.updateUser(user);
        return "redirect:/";
    }

}
