package com.example.demo.controllers;
import com.example.demo.entities.UserDto;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }
    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult result) {
        if(result.hasErrors()) {
            return "registration";
        }
        customUserDetailsService.createUser(userDto);
        return "redirect:login";
    }
}
