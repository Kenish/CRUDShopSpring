package com.projectmaking.Model;

import com.projectmaking.Repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.contains;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CartTest {

    private Cart cart;
    private ProductRepository repository;

    @Before
    public void setUp(){
        repository = mock(ProductRepository.class);
        cart = new CartImpl(repository);
    }

    @Test
    public void shouldAddProduct(){
        Product testProduct = new Product("test", "123", new BigDecimal(231), "lol");
        testProduct.setId(1L);
        repository.save(testProduct);
        cart.add(1L);
        assertEquals(1, cart.getAllProducts().size());
    }



    @Test
    public void shouldReturnProductList(){
        Product product1 = new Product("p1", "t1", new BigDecimal(1), "d1");
        Product product2 = new Product("p2", "t2", new BigDecimal(2), "d2");
        product1.setId(1L);
        product2.setId(2L);
        repository.save(product1);
        repository.save(product2);
        cart.add(1L);
        cart.add(2L);
        assertEquals(2, cart.getAllProducts().size());
        contains(cart.getAllProducts(), product1);
        contains(cart.getAllProducts(), product2);
    }





}