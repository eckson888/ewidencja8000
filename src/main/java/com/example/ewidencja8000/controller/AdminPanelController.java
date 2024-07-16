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

@Controller
public class AdminPanelController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @RequestMapping(path= {"/adminpanel"},method = RequestMethod.GET)
    public String adminpanel(Model model)
    {
        model.addAttribute("users",this.userService.getAll());
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

}
