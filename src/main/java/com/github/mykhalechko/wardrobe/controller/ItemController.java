package com.github.mykhalechko.wardrobe.controller;

import com.github.mykhalechko.wardrobe.models.Item;
import com.github.mykhalechko.wardrobe.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "items", method = RequestMethod.GET)
    public String listItems(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("listItems", this.itemService.listItems());

        return "items";
    }

    @RequestMapping(value = "/items/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("item") Item item) {
        System.out.println(item);
        if (item.getId() == 0) {
            this.itemService.addItem(item);
        } else {
            this.itemService.updateItem(item);
        }

        return "redirect:/items";
    }

    @RequestMapping("/remove/{id}")
    public String removeItem(@PathVariable("id") int id) {
        this.itemService.removeItem(id);

        return "redirect:/items";
    }

    @RequestMapping("edit/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", this.itemService.getItemById(id));
        model.addAttribute("listItems", this.itemService.listItems());

        return "items";
    }

    @RequestMapping("itemdata/{id}")
    public String itemData(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", this.itemService.getItemById(id));

        return "itemdata";
    }
}

