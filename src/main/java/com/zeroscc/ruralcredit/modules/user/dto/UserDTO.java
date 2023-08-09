package com.zeroscc.ruralcredit.modules.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;
    private String code;
    private String deptid;
    private String jobs;
    private String loginName;
    private String userName;
    private String userType;
    private String cardType;
    private String phonenumber;
    private String phonenumberTem;
    private Integer sex;
    private String address;
    private String busaddress;
    private String idcard;
    private String password;
    private String salt;
    private Integer status;
    private Integer delFlag;
    private String street;
    private String vallage;
    private String province;
    private Integer creditsite;
    private String credited;
    private String creditProd;
    private Long creditAmount;
    private Date creditTime;
    private Date creditEndTime;
    private Long userAmount;
    private String managerId;
    private String managerName;
    private Boolean migrant;
    private String migrantAddress;
    private Integer age;
    private Date birthday;
    private Integer orgId;

    private Set<RoleDTO> roles;
}