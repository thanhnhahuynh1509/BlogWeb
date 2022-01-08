package com.htn.controller;

import com.htn.models.Comment;
import com.htn.models.Post;
import com.htn.models.User;
import com.htn.service.CommentService;
import com.htn.service.PostService;
import com.htn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final PostService postService;

    public CommentController(CommentService commentService, UserService userService, PostService postService) {
        this.commentService = commentService;
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping("handleComment")
    public String handleComment(@RequestParam(name = "content") String content,
                                @RequestParam(name = "postId") Integer postId,
                                @RequestParam(name = "username") String username, Model model) {
        Comment comment = new Comment();

        if(content.length() < 1) {
            model.addAttribute("msg", "Bình luận không được dưới 1 ký tự");
            Post post = postService.getPost(postId);
            model.addAttribute("post", post);
            return "post";
        }

        comment.setContent(content);
        comment.setDateTime(new Date());

        User user = userService.getUser(username);

        int userId = user.getId();

        commentService.addComment(comment, userId, postId);

        return "redirect:/post/"+postId;
    }

    @RequestMapping("delete")
    public String deleteComment(@RequestParam(name = "cmtId") int cmtId,
                                @RequestParam(name = "postId") int postId) {
        commentService.deleteComment(cmtId);
        return "redirect:/post/"+postId;
    }

}
