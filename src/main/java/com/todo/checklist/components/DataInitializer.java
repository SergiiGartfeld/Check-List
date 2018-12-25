package com.todo.checklist.components;

import com.todo.checklist.model.User;
import com.todo.checklist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       Optional<User> userOptional = userRepository.findByUsername("admin");
       if(!userOptional.isPresent()){
           User user = new User();
           user.setUsername("admin");
           user.setPassword(bCryptPasswordEncoder.encode("admin"));
           userRepository.save(user);
       }
    }
}
