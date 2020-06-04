package com.epik.user_ev;

import com.epik.user_ev.endpoints.UserController;
import com.epik.user_ev.mapper.UserMapper;
import com.epik.user_ev.persistence.UserRepository;
import com.epik.user_ev.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackageClasses = {UserController.class, UserService.class, UserRepository.class, UserMapper.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
