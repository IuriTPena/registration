package com.cognizant.registration;

import com.cognizant.registration.config.DynamoDBConfig;
import com.cognizant.registration.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DynamoDBConfig.class,WebSecurityConfig.class})
public class RegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}
