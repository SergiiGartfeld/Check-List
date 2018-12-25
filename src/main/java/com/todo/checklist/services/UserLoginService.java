package com.todo.checklist.services;

import com.todo.checklist.model.User;
import com.todo.checklist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userNameFromForm) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userNameFromForm);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            String[] roles;
            if(user.isAdmin()){
                roles = new String[]{"USER", "ADMIN"};
            }else {
                roles = new String[]{"USER"};
            }

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .roles(roles)
                    .password(user.getPassword())
                    .accountExpired(false)
                    .accountLocked(false)
                    .build();

        }
        throw new UsernameNotFoundException("Couldn't find user in db.");
    }
}
