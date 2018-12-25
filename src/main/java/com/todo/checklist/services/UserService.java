package com.todo.checklist.services;

import com.todo.checklist.model.User;
import com.todo.checklist.model.dto.UserRegisterRequest;
import com.todo.checklist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public boolean tryRegister(UserRegisterRequest userRegisterRequest) {
        if(userRegisterRequest.getPassword().equals(userRegisterRequest.getPasswordConfirm())){
            Optional<User>userOptional  = userRepository.findByUsername(userRegisterRequest.getUsername());
            if(!userOptional .isPresent()){
                User user = new User();
                user.setAdmin(false);
                user.setUsername(userRegisterRequest.getUsername());
                user.setPassword(bCryptPasswordEncoder.encode(userRegisterRequest.getPassword()));
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
}
