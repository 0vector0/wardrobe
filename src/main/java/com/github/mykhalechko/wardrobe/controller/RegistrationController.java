//package com.github.mykhalechko.wardrobe.controller;
//
//import com.github.mykhalechko.wardrobe.models.Consumer;
//import com.github.mykhalechko.wardrobe.service.ConsumerServiceImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class RegistrationController {
//
//    private ConsumerServiceImpl consumerService = new ConsumerServiceImpl();
//
//    @RequestMapping(value = "registration", method = RequestMethod.GET)
//    public String listConsumers(Model model) {
//        model.addAttribute("consumer", new Consumer());
////        model.addAttribute("listConsumers", this.consumerService.listConsumers());
//
//        return "registration";
//    }
//
//
//    @RequestMapping(value = "registration/newuser", method = RequestMethod.POST)
//    public String addConsumer(@ModelAttribute("consumer") Consumer consumer) {
////        if(consumer.getId() == 0){
//        this.consumerService.addConsumer(consumer);
////        } else {
////            this.consumerService.updateConsumer(consumer);
////        }
//        return "redirect:/items";
//    }
//}
//
