package com.projectmaking.Service;

import com.projectmaking.Model.Product;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.ProductRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouritesService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    @Autowired
    public FavouritesService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    public HttpStatus addProductToList(Long productId){
        User newUser =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepository.findOne(productId);
        newUser.addFavourite(product);
        userRepository.saveAndFlush(newUser);
        return HttpStatus.ACCEPTED;
    }
    public List<Product> showAllProductsInList(){
        User newUser =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return newUser.getFavourites();
    }
    public HttpStatus removeProductFromList(Long productId){
        User user =userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepository.findOne(productId);
        user.removeFavourite(product);
        userRepository.saveAndFlush(user);
        productRepository.saveAndFlush(product);
        return HttpStatus.NO_CONTENT;
    }
}
