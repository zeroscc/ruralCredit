package com.zeroscc.ruralcredit.modules.user.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value =   type = IdType.AUTO)
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("deptid")
    private String deptid;

    @TableField("jobs")
    private String jobs;

    @TableField("Login_name")
    private String loginName;

    @TableField("User_name")
    private String userName;

    @TableField("user_type")
    private String userType = "1"; // 默认值为 "1"

    @TableField("card_type")
    private String cardType = "身份证"; // 默认值为 "身份证"

    @TableField("phonenumber")
    private String phonenumber;

    @TableField("Phonenumbertem")
    private String phonenumberTem;

    @TableField("sex")
    private Integer sex = 2; // 默认值为 2

    @TableField("address")
    private String address;

    @TableField("busaddress")
    private String busaddress;

    @TableField("idcard")
    private String idcard;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("status")
    private Integer status = 0; // 默认值为 0

    @TableField("del_flag")
    private Integer delFlag = 0; // 默认值为 0

    @TableField("street")
    private String street;

    @TableField("vallage")
    private String vallage;

    @TableField("province")
    private String province;

    @TableField("creditsite")
    private Integer creditsite;

    @TableField("credited")
    private String credited;

    @TableField("credit_prod")
    private String creditProd;

    @TableField("credit_amount")
    private BigDecimal creditAmount;

    @TableField("credit_time")
    private Date creditTime;

    @TableField("credit_endTime")
    private Date creditEndTime;

    @TableField("user_amount")
    private Long userAmount;

    @TableField("manager_id")
    private String managerId;

    @TableField("manager_name")
    private String managerName;

    @TableField("migrant")
    private Boolean migrant;

    @TableField("migrant_address")
    private String migrantAddress;

    @TableField("age")
    private Integer age;

    @TableField("birthday")
    private Date birthday;

    @TableField("org_id")
    private Integer orgId;

    @TableField(exist = false)
    private Set<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }
}

