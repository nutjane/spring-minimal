package com.example.sample.service;

import com.example.sample.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository applicationUserRepository;

    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.example.sample.model.User applicationUser = applicationUserRepository.findByName(name).orElse(null);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(name);
        }
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }
}