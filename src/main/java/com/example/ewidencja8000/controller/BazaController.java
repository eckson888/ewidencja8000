package com.example.ewidencja8000.controller;



import com.example.ewidencja8000.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BazaController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(path = {"/baza"}, method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("items", this.itemService.getAll());
        return "baza";
    }
}
