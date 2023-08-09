package com.zeroscc.ruralcredit.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeroscc.ruralcredit.modules.user.entity.User;

public interface UserMapper extends BaseMapper<User>{
    User findByUsername(String username);
}
