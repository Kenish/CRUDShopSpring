package com.projectmaking.Service;

import com.projectmaking.Model.Comment;
import com.projectmaking.Model.Product;
import com.projectmaking.Repository.CommentRepository;
import com.projectmaking.Repository.ProductRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    public HttpStatus addComment(Comment comment,Long productID){
        comment.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        comment.setDate(Calendar.getInstance());
        Product product = productRepository.findOne(productID);
        product.addComment(comment);
        commentRepository.save(comment);
        productRepository.saveAndFlush(product);
        commentRepository.flush();
        return HttpStatus.CREATED;
    }
    public List<Comment> getComments(Long productID){
       return productRepository.findOne(productID).getComments();

    }
}
