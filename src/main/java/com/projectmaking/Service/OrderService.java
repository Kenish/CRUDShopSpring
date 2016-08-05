package com.projectmaking.Service;

import com.projectmaking.Model.CartImpl;
import com.projectmaking.Model.Order;
import com.projectmaking.Model.User;
import com.projectmaking.Repository.OrderRepository;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
@Service
public class OrderService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private CartImpl cart;

    @Autowired
    public OrderService(UserRepository userRepository, CartImpl cart,OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.cart = cart;
        this.orderRepository=orderRepository;
    }

    public HttpStatus addOrder(){
        Order order = new Order(Calendar.getInstance(),cart.getSummaryCost(),cart.getAllProducts(),false);
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.addOrder(order);
        orderRepository.save(order);
        userRepository.save(user);
        orderRepository.flush();
        userRepository.flush();
        cart.getAllProducts().clear();
        return HttpStatus.OK;
    }
}
