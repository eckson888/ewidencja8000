package com.example.ewidencja8000.controller;


import com.example.ewidencja8000.model.User;
import com.example.ewidencja8000.service.ItemService;
import com.example.ewidencja8000.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminPanelController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @RequestMapping(path= {"/adminpanel"},method = RequestMethod.GET)
    public String adminpanel(Model model)
    {
        List<User> usersExceptCurrent;
        usersExceptCurrent = this.userService.getAll();
        User current = this.userService.getCurrentUser();
        usersExceptCurrent.remove(current);
        model.addAttribute("users",usersExceptCurrent);
        return "adminpanel";
    }

    @RequestMapping(path = "/adminpanel/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @RequestMapping(path = "/adminpanel/add", method = RequestMethod.POST)
    public String add(@ModelAttribute User user) {
        this.userService.registerUser(user);
        return "redirect:/adminpanel";
    }

    @RequestMapping(path ="/adminpanel/delete", method = RequestMethod.POST)
    public String delete(@RequestParam long id)
    {
        userService.delete(id);
        return "redirect:/adminpanel";
    }
}
