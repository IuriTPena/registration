package com.cognizant.registration.controller;

import com.cognizant.registration.domain.User;
import com.cognizant.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("${url.register}")
public class ResgistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String test() {
        return "It works!";
    }

    @PostMapping
    public String registration(@RequestBody User user) {
        return registrationService.register(user);
    }
}
