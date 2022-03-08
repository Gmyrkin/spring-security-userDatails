package com.example.education_3_1_2.services;

import com.example.education_3_1_2.dao.UserDao;
import com.example.education_3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
