//package com.lrm.controller;
//
//import com.lrm.po.Comment;
//import com.lrm.po.User;
//import com.lrm.service.BlogService;
//import com.lrm.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class
//CommentController {
//
//    @Autowired
//    private CommentService commentService;
//
//    @Autowired
//    private BlogService blogService;
//
//    @Value("${comment.touristAvatar}")
//    private String touristAvatar;
//
//    @Value("${comment.userAvatar}")
//    private String userAvatar;
//
//
//    @GetMapping("/comments/{blogId}")
//    public String comments(@PathVariable Long blogId, Model model) {
//        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
//        return "blog :: commentList";
//    }
//
//
//    @PostMapping("/comments")
//    public String post(Comment comment, HttpSession session) {//上传评论时
//        Long blogId = comment.getBlog().getId();
//        comment.setBlog(blogService.getBlog(blogId));
//        User user = (User) session.getAttribute("user");
//        if (user != null) {
//            Long userId = user.getId();
//            comment.setAvatar(userAvatar);
//            comment.setUserId(userId);
//            if(user.getId().equals(comment.getBlog().getUser().getId()))
//                comment.setAdminComment(true);
//            else comment.setAdminComment(false);
//        } else {
//            comment.setAvatar(touristAvatar);
//        }
//        commentService.saveComment(comment);
//        return "redirect:/comments/" + blogId;
//    }
//
//
//
//}
