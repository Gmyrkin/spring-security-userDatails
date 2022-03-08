package com.example.education_3_1_2.controller;


import com.example.education_3_1_2.model.Role;
import com.example.education_3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.education_3_1_2.services.RoleService;
import com.example.education_3_1_2.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;
@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
@Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired (required = true)
   // @Qualifier (value = "userService")
    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @Autowired
    PasswordEncoder passwordEncoder;
//    @GetMapping("/test")
//    public String testUser (ModelMap model){
////        model.addAttribute("user", new User(1, "Tim", "123"));
//        List<User> users = new ArrayList<>();
//        users.add(new User(23, "Dim", "123"));
//        users.add(new User(25, "Tim", "456"));
//        users.add(new User(20, "Rim", "789"));
//        model.addAttribute("admin", users);
//
//        return "test";
//    }

    @GetMapping(value = "/user")
    public String listUsers (ModelMap model) {
       // model.addAttribute("user", new User(1,"Tim","123"));
        model.addAttribute("listUser",userService.getAllUser());

        return "admin";
    }

    @PostMapping("/user/add")
    public String addUser (@ModelAttribute User user){
        if (user.getId() == 0) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Set<Role> roleDef = new HashSet<>();
            roleDef.add(roleService.getRoleId(2L));
            user.setRoles(roleDef);
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "admin";
    }

    @GetMapping("/user/add")
    public String addUser (){
        User user = new User();
        user.setName("test");
        user.setPassword(passwordEncoder.encode("test"));
        userService.addUser(user);
        return "admin";
    }
    @GetMapping("/user/update/{id}")
    public ModelAndView getUserId (@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("userEdit", userService.getUserId(id));


        return modelAndView;
    }
    @PostMapping("/update/{id}")
    public String updateUser (@ModelAttribute User user, @PathVariable("id") long id){
        User userFromDB = userService.getUserId(id);
        if (userFromDB != null) {
            userFromDB.setName(user.getName());
            userFromDB.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.updateUser(userFromDB);
        }

        return "admin";
    }

    @GetMapping ("/remove/{id}")
    public String deleteUser (@PathVariable("id") long id){
        User userFind = userService.getUserId(id);
        if (userFind != null){
            userService.deleteUser(userFind);
        }

        return "admin";
    }


}