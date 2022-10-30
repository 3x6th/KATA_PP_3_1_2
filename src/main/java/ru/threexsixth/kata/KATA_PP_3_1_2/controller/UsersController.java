package ru.threexsixth.kata.KATA_PP_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.threexsixth.kata.KATA_PP_3_1_2.model.User;
import ru.threexsixth.kata.KATA_PP_3_1_2.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/updateInfo/{id}")
    public String updateUser(ModelMap model, @PathVariable int id) {
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }

    @PostMapping(value = "deleteUser/{id}")
    public String deleteUser(@PathVariable int id, ModelMap model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
