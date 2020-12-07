package com.afdev1.nuvucard.security;

import com.afdev1.nuvucard.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/")
    public String base(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("clients", clientService.loadAll());
            return "/home";
        }
        return "/login";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password,
                        Model model) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {

        }
        model.addAttribute("clients", clientService.loadAll());
        return "redirect:/home";
    }
}
