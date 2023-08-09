package com.zeroscc.ruralcredit.core.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 主键通用响应类，用于添加后返回内容
 * </p>
 *
 * @author 聪明笨狗
 * @since 2019-04-20 12:15
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class BaseIdRespDTO extends BaseDTO {


    private String id;
}
