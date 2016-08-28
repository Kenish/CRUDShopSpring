package com.projectmaking.Config;

import com.projectmaking.Model.User;
import com.projectmaking.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private UserManagementService userManagementService;

    @Override
    public void run(String... strings) throws Exception {
        User admin = new User("admin","admin1","admin@page.com");
        admin.setRole("ADMIN");
        userManagementService.register(admin);
    }
}
