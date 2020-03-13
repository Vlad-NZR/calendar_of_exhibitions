package com.example.service;

import com.example.domain.User;
import com.example.service.UserDetailsImpl;
import com.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByLogin(login);

        user.orElseThrow(() -> new UsernameNotFoundException(login + " not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}
