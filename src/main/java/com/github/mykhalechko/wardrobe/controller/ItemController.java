package com.github.mykhalechko.wardrobe.controller;

import com.github.mykhalechko.wardrobe.models.Item;
import com.github.mykhalechko.wardrobe.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    // This method will list all existing employees.
    @RequestMapping(value = "/item" , method = RequestMethod.GET)
    public String listItems(ModelMap model) {

        ItemService itemService = new ItemService();

        List<Item> itemsList = itemService.findAll();
        model.addAttribute("itemsList", itemsList);
        System.out.println(itemsList);
        return "item";
    }


//    @RequestMapping(value = "/item", method = RequestMethod.GET)
//    public ModelAndView item(){
//
//
//        ItemService itemService = new ItemService();
//        List<Item> itemsList = itemService.findAll();
//
//        ModelAndView model = new ModelAndView("item");
//        model.addObject("itemsList", itemsList);
//
//        return model;
//    }
}
