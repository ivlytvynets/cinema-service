package com.dev.theatre.controller;

import com.dev.theatre.model.Role;
import com.dev.theatre.model.User;
import com.dev.theatre.service.RoleService;
import com.dev.theatre.service.UserService;
import java.util.Set;
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
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ADMIN");
        roleService.add(roleAdmin);

        Role roleUser = new Role();
        roleUser.setRoleName("USER");
        roleService.add(roleUser);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1234");
        admin.setRoles(Set.of(roleAdmin, roleUser));
        userService.add(admin);
    }
}
