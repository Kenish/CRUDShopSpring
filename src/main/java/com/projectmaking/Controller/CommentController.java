package com.projectmaking.Controller;

import com.projectmaking.Model.Comment;
import com.projectmaking.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/api/products/{id}/comments",method = RequestMethod.POST)
    public HttpStatus addComment(@RequestBody Comment comment, @PathVariable("id") Long id){
        return commentService.addComment(comment,id);
    }

    @RequestMapping(value = "/api/products/{id}/comments",method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable("id") Long id){
        return commentService.getComments(id);
    }
}
