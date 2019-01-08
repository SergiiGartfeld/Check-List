package com.todo.checklist.configuration;

import com.todo.checklist.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BasicConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //  @Bean
    //  public User createAdminUser(){
    //      User user= new User();
    //      user.setUsername("admin");
    //      user.setPassword("admin");
    //      return user;
    //  }


}
