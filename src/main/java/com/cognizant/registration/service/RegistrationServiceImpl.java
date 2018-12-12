package com.cognizant.registration.service;

import com.cognizant.registration.domain.User;
import com.cognizant.registration.repository.RegistrationRepository;
import com.cognizant.registration.util.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String register(final User user) {
        String result;

        Optional<User> userOptional = registrationRepository.findById(user.getEmail());

        if (!userOptional.isPresent()) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            registrationRepository.save(user);
            result = ErrorCodeEnum.SUCCESS.getValue();
        } else {
            result = ErrorCodeEnum.USER_ALREADY_EXISTS.getValue();
        }

        return result;
    }
}
