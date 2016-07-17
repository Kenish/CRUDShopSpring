package com.projectmaking.Controller;

import com.projectmaking.Model.Cart;
import com.projectmaking.Model.CartImpl;
import com.projectmaking.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Async
@RequestMapping("/api/cart")
public class CartController {
    private final Cart cart;
    @Autowired
    CartController(CartImpl cart){
        this.cart = cart;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Product> getCart() {
        return cart.getAllProducts();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void DeleteItem(@PathVariable Long id){
        cart.remove(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void addProduct(@PathVariable Long id){
        cart.add(id);
    }
}
