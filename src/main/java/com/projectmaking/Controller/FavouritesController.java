package com.projectmaking.Controller;

import com.projectmaking.Model.Product;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.ProductRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavouritesController {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    FavouritesController(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    @RequestMapping(value = "api/users/{id}/favourite/{ProductId}",method = RequestMethod.POST)
    HttpStatus addFavouriteProduct(@PathVariable("id") Long id,@PathVariable("ProductId")Long productId){
        User newUser = userRepository.findOne(id);
        Product product = productRepository.findOne(productId);
        newUser.addFavourite(product);
        product.addToList(newUser);
        productRepository.saveAndFlush(product);
        userRepository.saveAndFlush(newUser);
        return HttpStatus.ACCEPTED;
    }
    @RequestMapping(value = "api/users/{id}/favourite/{ProductId}",method = RequestMethod.DELETE)
    HttpStatus removeFavouriteProduct(@PathVariable("id") Long id,@PathVariable("ProductId")Long productId){
        userRepository.findOne(id).removeFavourite(productRepository.findOne(productId));
        return HttpStatus.NO_CONTENT;
    }
}
