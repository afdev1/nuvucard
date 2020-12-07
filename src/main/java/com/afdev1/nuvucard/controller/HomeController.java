package com.afdev1.nuvucard.controller;

import com.afdev1.nuvucard.model.Client;
import com.afdev1.nuvucard.services.AdministratorService;
import com.afdev1.nuvucard.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("clients", clientService.loadAll());
        return "/home";
    }

    @PostMapping("/save")
    public String save(Client client){
        clientService.save(client);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    //@ResponseBody
    public void update(Model model, Long id){
        //return clientService.update(id);
    }

    @GetMapping("/delete")
    public String delete(Long id){
        clientService.delete(id);
        return "redirect:/home";
    }
}
