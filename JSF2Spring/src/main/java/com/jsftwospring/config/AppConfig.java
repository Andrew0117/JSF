package com.jsftwospring.config;

import com.jsftwospring.services.interfaces.UserService;
import com.jsftwospring.services.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
@Configuration
@ComponentScan("com.jsftwospring")
public class AppConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
