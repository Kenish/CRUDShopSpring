package com.projectmaking.Model;

import com.projectmaking.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)

public class CartImpl implements Cart {

    private ProductRepository productRepository;

    @Autowired
    public CartImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    private List<Product> productList = new ArrayList<>();

    @Override
    public void add(Long id) {
        productList.add(productRepository.findOne(id));
    }

    @Override
    public void remove(long id) {
        Predicate<Product> i = (product)->product.getId()==id;
        productList.removeIf(i);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public BigDecimal getSummaryCost() {
        BigDecimal sum = new BigDecimal(0);
        for (Product product:productList){
            sum = sum.add(product.getPrice());
        }
        return sum;

    }
}
