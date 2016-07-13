package com.projectmaking.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)

public class CartImpl implements Cart {
    private List<Product> productList = new ArrayList<>();
    @Override
    public void add(Product product) {
        productList.add(product);

    }

    @Override
    public void remove(long id) {
        Predicate<Product> i = (p)->p.getId()==id;
        productList.removeIf(i) ;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public BigDecimal getSummaryCost() {;
        BigDecimal sum = new BigDecimal(0);
        for (Product product:productList){
            sum = sum.add(product.getPrice());
        }
        return sum;

    }
}
