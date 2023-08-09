package com.zeroscc.ruralcredit.core.api.dto;

import lombok.Data;

/**
 * <p>
 * 支付通用请求类
 * </p>
 *
 * @author 聪明笨狗
 * @since 2019-04-20 12:15
 */
@Data
public class PayReqDTO extends BaseDTO {

    private String orderId;
}
