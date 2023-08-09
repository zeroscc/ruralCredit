package com.zeroscc.ruralcredit.modules.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private Long roleId;
}