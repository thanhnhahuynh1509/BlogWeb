package com.htn.controller;

import com.htn.models.Post;
import com.htn.models.User;
import com.htn.service.PostService;
import com.htn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("showForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "login";

    }

    @RequestMapping("showForm/{postId}")
    public String showForm(Model model, @PathVariable Integer postId) {
        model.addAttribute("user", new User());
        model.addAttribute("postId", postId);
        return "login";
    }

    @RequestMapping("handleLogin")
    public String handleLogin(@RequestParam(name = "username", required = false) String username,
                              @RequestParam(name = "password", required = false) String password,
                              @RequestParam(name = "postId", required = false) Integer postId,
                              Model model, HttpSession httpSession) {

        User user = userService.getUser(username);

        if(user == null) {
            System.out.println("check 1");
            model.addAttribute("msg", "Tên tài khoản không đúng");
            return "login";
        }
        if(!user.getPassword().equals(password)) {
            System.out.println("check 2");
            model.addAttribute("msg", "Mật khẩu không đúng");
            return "login";
        }

        httpSession.setAttribute("username", username);
        httpSession.setAttribute("name", user.getFullName().charAt(0));

        if(postId != null) {
            return "redirect:/post/" + postId;
        }

        return "redirect:/";
    }


    @RequestMapping("register")
    public String handleRegister(@RequestParam(required = false) String username,
                                 @RequestParam(required = false) String password,
                                 @RequestParam(required = false) String passwordAgain,
                                 @RequestParam(required = false) String fullName,
                                 @RequestParam(name = "postId", required = false) Integer postId,
                                 Model model, HttpSession session) {

        User get = userService.getUser(username);

        if(username.length() < 8 || password.length() < 8) {
            model.addAttribute("msgRegis", "Tài khoản và Mật khẩu không được dưới 8 ký tự");
            return "login";
        } else if(!password.equals(passwordAgain)) {
            model.addAttribute("msgRegis", "Mật khẩu không trùng khớp");
            return "login";
        }
        else if(get != null) {
            model.addAttribute("msgRegis", "Tài khoản đã tồn tại");
            return "login";
        } else
        {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullName(fullName);
            userService.saveUser(user);
            session.setAttribute("username", username);
            session.setAttribute("name", fullName.charAt(0));

        }

        if(postId != null) {
            return "redirect:/post/" + postId;
        }

        return "redirect:/";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("name");
        return "redirect:/";
    }

}
