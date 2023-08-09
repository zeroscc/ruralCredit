package com.zeroscc.ruralcredit.core.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 是否状态通用请求
 * </p>
 *
 * @author 聪明笨狗
 * @since 2019-04-20 12:15
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class BaseIfReqDTO extends BaseDTO {



    private List<String> ids;


    private Boolean enabled;
}
