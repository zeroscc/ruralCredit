package com.zeroscc.ruralcredit.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zeroscc.ruralcredit.modules.user.dto.UserDTO;
import com.zeroscc.ruralcredit.modules.user.entity.User;

public interface UserService extends IService<User> {

        UserDTO findByLoginName(String username);
}
