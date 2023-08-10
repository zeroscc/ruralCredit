package com.zeroscc.ruralcredit.modules.user.controller;

import com.zeroscc.ruralcredit.core.api.ApiRest;
import com.zeroscc.ruralcredit.core.api.controller.BaseController;
import com.zeroscc.ruralcredit.modules.user.dto.UserDTO;
import com.zeroscc.ruralcredit.modules.user.entity.User;
import com.zeroscc.ruralcredit.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService baseService;

    @RequestMapping(value = "/get", method = {RequestMethod.POST})
    public ApiRest<UserDTO> login(@RequestBody UserDTO reqDTO) {
        System.out.println("reqDTO = " + reqDTO);
        UserDTO respDTO = baseService.findByLoginName(reqDTO.getLoginName());
        return super.success(respDTO);
    }

    @GetMapping("/hello")
    public String get() {
        return "hello world";
    }
}
