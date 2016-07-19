package com.projectmaking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
private Product(){}

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @NotNull
    private String name;
    private String type;
    @NotNull
    private BigDecimal price;
    @ManyToMany
    private List<User> userList;

    public Product(String name, String type, BigDecimal price, String description) {
        this.description = description;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addToList(User user){
        if (!userList.contains(user)){
            userList.add(user);
        }
    }
    public void removeFromList(User user){
        userList.remove(user);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
