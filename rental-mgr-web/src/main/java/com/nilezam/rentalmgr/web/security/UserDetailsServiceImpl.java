package com.nilezam.rentalmgr.web.security;

import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.model.user.UserRepository;
import com.nilezam.rentalmgr.model.user.UserSpecification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.get(new UserSpecification.MailEqual(username));
        return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), Collections
                .emptyList());
    }
}
