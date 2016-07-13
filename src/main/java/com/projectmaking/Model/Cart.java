package com.projectmaking.Model;

import java.math.BigDecimal;
import java.util.List;

public interface Cart {

    void add(Product product);
    void remove(long id);
    List<Product> getAllProducts();
    BigDecimal getSummaryCost();

}
