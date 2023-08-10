package com.zeroscc.ruralcredit.modules.user.service.impl;

import com.zeroscc.ruralcredit.modules.user.entity.LoginUser;
import com.zeroscc.ruralcredit.modules.user.entity.User;
import com.zeroscc.ruralcredit.modules.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new LoginUser(user);
    }
}
