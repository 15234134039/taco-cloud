package com.it.tacocloud.controller;

import com.it.tacocloud.data.UserRepository;
import com.it.tacocloud.pojo.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/19 17:07
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepo;

    /**
     * com.it.tacocloud.config.SecurityConfig#encoder()
     */
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}

