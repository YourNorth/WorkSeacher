package com.tenere_bufo.itis.security.service;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User userSimple = userOptional.get();
            return new UserDetailsImpl(userSimple);
        } throw new UsernameNotFoundException("User not found");
    }

}
