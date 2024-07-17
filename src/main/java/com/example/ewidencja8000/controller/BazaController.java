package com.example.ewidencja8000.controller;



import com.example.ewidencja8000.model.Item;
import com.example.ewidencja8000.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BazaController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(path = {"/baza"}, method = RequestMethod.GET)
    public String main(Model model) {
        //
        model.addAttribute("items", this.itemService.getAll());
        return "baza";
    }

    @RequestMapping(path={"/baza/add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("item",new Item());
        return "item-form";
    }

    @RequestMapping(path={"/baza/add"}, method = RequestMethod.POST)
    public String add(@ModelAttribute Item item){
        this.itemService.addItem(item);
        return "redirect:/baza";
    }

    @RequestMapping(path="/baza/delete",method = RequestMethod.POST)
    public String delete(@RequestParam int id)
    {
        this.itemService.delete(id);
        return "redirect:/baza";
    }

    @RequestMapping(path = "/baza/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Optional<Item> itemOpt = this.itemService.getById(id);
        if (itemOpt.isEmpty()) {
            return "redirect:/baza";
        }
        model.addAttribute("item", itemOpt.get());
        return "item-form";
    }

    @RequestMapping(path = "/baza/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, @ModelAttribute Item item) {
        this.itemService.saveOrUpdate(item);
        return "redirect:/baza";
    }


    @RequestMapping(path = "/baza/move/{id}", method = RequestMethod.GET)
    public String move(@PathVariable int id, Model model) {
        Optional<Item> itemOpt = this.itemService.getById(id);
        if (itemOpt.isEmpty()) {
            return "redirect:/baza";
        }
        Item newItem = itemOpt.get().copyOf();
        model.addAttribute("item", newItem);
        return "move-form";
    }

    @RequestMapping(path = "/baza/move/{id}", method = RequestMethod.POST)
    public String move(@PathVariable int id, @ModelAttribute Item item) {
        this.itemService.saveOrUpdate(item);
        return "redirect:/baza";
    }

    @RequestMapping(path = "/baza/copy/{id}", method = RequestMethod.GET)
    public String copy(@PathVariable int id, Model model) {
        Optional<Item> itemOpt = this.itemService.getById(id);
        if (itemOpt.isEmpty()) {
            return "redirect:/baza";
        }

        Item newItem = itemOpt.get().copyOf();
        newItem.setSerial("");
        model.addAttribute("item", newItem);
        return "item-form";
    }

    @RequestMapping(path = "/baza/copy/{id}", method = RequestMethod.POST)
    public String copy(@PathVariable int id, @ModelAttribute Item item) {
        Item newItem = item.copyOf();
        this.itemService.saveOrUpdate(newItem);
        return "redirect:/baza";
    }

    @RequestMapping(path = "/baza/search",method=RequestMethod.GET)
    public String search(@RequestParam String keyword, Model model)
    {
        if (keyword != null) {
            List<Item> list = itemService.getByKeyword(keyword);
            model.addAttribute("items", list);
            model.addAttribute("keyword",keyword);
        } else {
            List<Item> list = itemService.getAll();
            model.addAttribute("items", list);
        }
        return "/baza";
    }



}
