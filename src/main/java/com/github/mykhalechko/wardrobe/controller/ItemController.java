package com.github.mykhalechko.wardrobe.controller;

import com.github.mykhalechko.wardrobe.models.Item;
import com.github.mykhalechko.wardrobe.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService = new ItemService();

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String listItems(ModelMap model) {

        List<Item> itemsList = itemService.findAll();
        model.addAttribute("itemsList", itemsList);
        System.out.println(itemsList);
        return "item";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    public String addItem(@ModelAttribute("itemForm") Item item, ModelMap model) {

//        itemService.persist(item);
//        model.addAttribute("name", item.getName());
//        model.addAttribute("description", item.getDescription());
//        model.addAttribute("size", item.getSize());
//        model.addAttribute("color", item.getColor());
//        model.addAttribute("price", item.getPrice());
        return "newitem";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("itemForm") Item item,
                             ModelMap model) {
        itemService.persist(item);

        return "item";
    }
}
//    private String name;
//    private String description;
//    private String size;
//    private String color;
//    private BigDecimal price;


//    }