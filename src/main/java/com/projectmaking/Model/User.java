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
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private Integer postalCode;
    @NotNull
    private String address;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> favourites;
    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;
    private String role = "USER";
    @Transient
    private boolean enabled = true;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, String country, String city, Integer postalCode, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.role = "USER";
        this.enabled = true;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", address='" + address + '\'' +
                '}';
    }
}
