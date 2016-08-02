package com.projectmaking.Controller;

import com.projectmaking.Model.Product;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.ProductRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FavouritesController {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    FavouritesController(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    @RequestMapping(value = "api/users/favourite/{ProductId}",method = RequestMethod.POST)
    HttpStatus addFavouriteProduct(@PathVariable("ProductId")Long productId){
        User newUser =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepository.findOne(productId);
        newUser.addFavourite(product);
        userRepository.saveAndFlush(newUser);
        return HttpStatus.ACCEPTED;
    }
    @RequestMapping(value = "api/users/favourite",method = RequestMethod.GET)
    List<Product> getFavourites(){
        User newUser =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return newUser.getFavourites();
    }
    @RequestMapping(value = "api/users/favourite/{ProductId}",method = RequestMethod.DELETE)
    HttpStatus removeFavouriteProduct(@PathVariable("ProductId")Long productId){
        User user =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepository.findOne(productId);
        user.removeFavourite(product);
        userRepository.saveAndFlush(user);
        productRepository.saveAndFlush(product);
        return HttpStatus.NO_CONTENT;
    }
}
