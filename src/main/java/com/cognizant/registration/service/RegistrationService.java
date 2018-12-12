package com.cognizant.registration.service;

import com.cognizant.registration.domain.User;
import org.springframework.stereotype.Service;

public interface RegistrationService {
    String register(User user);
}
