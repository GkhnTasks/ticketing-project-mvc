package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping ("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll()); // bring me al, roles from DB
        model.addAttribute("users",userService.findAll()); // bring me al, roles from DB
        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user")UserDTO user, Model model){

//        model.addAttribute("user",new UserDTO());
//        model.addAttribute("roles",roleService.findAll());
           userService.save(user);
//        model.addAttribute("users",userService.findAll());
//        return "/user/create"; //user,roles,users

        return "redirect:/user/create"; // if we use redirect we dont need uncomment lines
    }



}
