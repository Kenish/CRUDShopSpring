package com.projectmaking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity

public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> favourites;

    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;
    private String role = "USER";

    @Transient
    private boolean enabled = true;

    @OneToMany(targetEntity = Address.class)
    private List<Address> addresses;

    public User() {} //jpa

    public User(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.role = "USER";
        this.email=email;
        this.enabled = true;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getFavourites() {
        return favourites;
    }

    public void addFavourite(Product product) {
        if (!favourites.contains(product)) {
            favourites.add(product);
        }
    }

    public void removeFavourite(Product product) {
        favourites.remove(product);
    }

    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addAdress(Address address){
        addresses.add(address);
    }

    public void removeAdress(Address address){
            addresses.remove(address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", favourites=" + favourites +
                ", orders=" + orders +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", addresses=" + addresses +
                '}';
    }
}
