package com.projectmaking.Controller;

import com.projectmaking.Model.Product;
import com.projectmaking.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductController {
    final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "products",method = RequestMethod.POST)
    public Product add(@RequestBody Product product){
        return repository.saveAndFlush(product);
    }
    @RequestMapping(value = "product/{id}",method = RequestMethod.GET)
    public Product getOne(@PathVariable Long id){
        return repository.findOne(id);
    }
    @RequestMapping(value = "products",method = RequestMethod.GET)
    public List<Product> getAll(){
        return repository.findAll();
    }
    @RequestMapping(value = "product/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        repository.delete(id);
    }
}
