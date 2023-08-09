package com.zeroscc.ruralcredit.core.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 按关键字查询请求通用类
 * </p>
 *
 * @author 聪明笨狗
 * @since 2019-04-20 12:15
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class BaseQueryReqDTO extends BaseDTO {



    private Date statDateL;


    private Date statDateR;


    private String q;
}
