package com.projectmaking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity

public class User {
    @Id @GeneratedValue private Long id;
    @NotNull
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
    public User(){}


    public User(String username, String password, String firstName, String lastName, String country, String city, Integer postalCode, String address) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addFavourite(Product product){
        if (!favourites.contains(product)){
        favourites.add(product);}
    }

    public void removeFavourite(Product product){
        favourites.remove(product);
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
