package com.cognizant.registration.controller;

import com.cognizant.registration.domain.User;
import com.cognizant.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${url.register}")
public class RegistrationController {

    @Autowired
    private RegistrationRepository repository;

    @PostMapping
    public void register(@RequestBody User user) {
        repository.register(user);
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String email) {
        User user = repository.getUser(email);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("email") String email) {
        User user = new User();
        user.setEmail(email);
        repository.deleteUser(user);

        return "Successfully deleted user: " + user.getEmail();
    }
}