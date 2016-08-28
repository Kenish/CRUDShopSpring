package com.projectmaking.Controller;

import com.projectmaking.Model.Product;
import com.projectmaking.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private  ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(value = "/api/products/{productID}",method = RequestMethod.GET)
    public Product getProducts(@PathVariable Long productID){
        return productRepository.findOne(productID) ;
    }

    @RequestMapping(value = "/api/products",method = RequestMethod.POST)
    public HttpStatus addProduct(@RequestBody Product product){
        productRepository.saveAndFlush(product);
        return HttpStatus.CREATED;
    }


}
