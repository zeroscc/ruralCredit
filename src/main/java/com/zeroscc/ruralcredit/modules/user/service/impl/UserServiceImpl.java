package com.zeroscc.ruralcredit.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroscc.ruralcredit.modules.user.entity.User;
import com.zeroscc.ruralcredit.modules.user.mapper.UserMapper;
import com.zeroscc.ruralcredit.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


}
