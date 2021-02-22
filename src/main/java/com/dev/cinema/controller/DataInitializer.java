package com.dev.cinema.controller;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void inject() {
        Role role = new Role();
        role.setRoleName("ADMIN");
        roleService.add(role);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1234");
        admin.setRole(role);
        userService.add(admin);
    }
}
