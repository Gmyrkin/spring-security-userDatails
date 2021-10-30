//package ru.gmyrkin.crud.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.gmyrkin.crud.model.Role;
//import ru.gmyrkin.crud.model.User;
//import ru.gmyrkin.crud.services.RoleService;
//import ru.gmyrkin.crud.services.UserService;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class DbInit {
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    private void postConstruct() {
//        Role role = new Role();
//        role.setId(1l);
//        role.setName("ROLE_ADMIN");
//        roleService.addRole(role);
//
//        Role roleUser = new Role();
//        roleUser.setId(2l);
//        roleUser.setName("ROLE_USER");
//        roleService.addRole(roleUser);
//
//        User userDima = new User();
//        userDima.setName("dima");
//        userDima.setPassword(passwordEncoder.encode("dima"));
//        Set<Role> rolesForDima = new HashSet<>();
//        rolesForDima.add(roleService.getRoleId(1l));
//        rolesForDima.add(roleService.getRoleId(2l));
//        userDima.setRoles(rolesForDima);
//        userService.addUser(userDima);
//
//        User userSasha = new User();
//        userSasha.setName("sasha");
//        userSasha.setPassword(passwordEncoder.encode("sasha"));
//        Set<Role> rolesForSasha = new HashSet<>();
//        rolesForSasha.add(roleService.getRoleId(2l));
//        userSasha.setRoles(rolesForSasha);
//        userService.addUser(userSasha);
//    }
//}
