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

    Cart cart;
    ProductRepository repository;

    @Before
    public void setUp(){
        cart = new CartImpl();
        repository = mock(ProductRepository.class);
    }

    @Test
    public void shouldAddProduct(){
        cart.add(new Product("test", "dildo", new BigDecimal(231), "big black"));
        assertEquals(1, cart.getAllProducts().size());
    }

    @Test
    public void shouldRemoveProduct(){
        Product product1 = new Product("p1", "t1", new BigDecimal(1), "d1");
        Product product2 = new Product("p2", "t2", new BigDecimal(2), "d2");
        product1.setId(1L);
        product2.setId(2L);
        cart.add(product1);
        cart.add(product2);
        cart.remove(product1.getId());
        assertEquals(1, cart.getAllProducts().size());
        contains(cart.getAllProducts(), product1);
    }

    @Test
    public void shouldReturnProductList(){
        Product product1 = new Product("p1", "t1", new BigDecimal(1), "d1");
        Product product2 = new Product("p2", "t2", new BigDecimal(2), "d2");
        product1.setId(1L);
        product2.setId(2L);
        cart.add(product1);
        cart.add(product2);
        assertEquals(2, cart.getAllProducts().size());
        contains(cart.getAllProducts(), product1);
        contains(cart.getAllProducts(), product2);
    }

    @Test
    public void shouldReturnPrice(){
        Product product1 = new Product("p1", "t1", new BigDecimal(1), "d1");
        Product product2 = new Product("p2", "t2", new BigDecimal(2), "d2");
        product1.setId(1L);
        product2.setId(2L);
        cart.add(product1);
        cart.add(product2);
        assertEquals(new BigDecimal(3), cart.getSummaryCost());
    }

    @Test
    public void shouldReturnPriceAfterRemoveProduct(){
        Product product1 = new Product("p1", "t1", new BigDecimal(18), "d1");
        Product product2 = new Product("p2", "t2", new BigDecimal(13), "d2");
        product1.setId(1L);
        product2.setId(2L);
        cart.add(product1);
        cart.add(product2);
        cart.remove(product1.getId());
        assertEquals(new BigDecimal(13), cart.getSummaryCost());
    }


}