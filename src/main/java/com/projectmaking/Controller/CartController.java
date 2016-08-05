package com.projectmaking.Controller;

import com.projectmaking.Model.Cart;
import com.projectmaking.Model.CartImpl;
import com.projectmaking.Model.Product;
import com.projectmaking.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Async
@RequestMapping("/api/cart")
public class CartController {
    private final Cart cart;
    private OrderService orderService;
    @Autowired
    CartController(CartImpl cart,OrderService orderService){
        this.cart = cart;
        this.orderService = orderService;
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

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public HttpStatus makeOrder(){
        return orderService.addOrder();
    }
}
