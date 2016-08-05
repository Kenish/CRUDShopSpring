package com.projectmaking.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "UserOrder")
public class Order {
    @GeneratedValue
    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar date;
    private BigDecimal TotalPrice;

    @ManyToMany(targetEntity = Product.class)
    private List <Product> productList;


    boolean paid;
    public Order(){} //jpa
    public Order(Calendar date, BigDecimal totalPrice, List<Product> productList, boolean paid) {
        this.date = date;
        TotalPrice = totalPrice;
        this.productList = productList;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }



    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        TotalPrice = totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", TotalPrice=" + TotalPrice +
                ", productList=" + productList +
                ", paid=" + paid +
                '}';
    }
}
