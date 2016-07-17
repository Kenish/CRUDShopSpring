package com.projectmaking.Repository;

import com.projectmaking.Model.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "NoPassword",types = User.class)
public interface NoPassword {
    String getUsername();

    String getFirstName();

    String getLastName();

    String getCountry();

    String getCity();

    Integer getPostalCode();

    String getAddress();
}
