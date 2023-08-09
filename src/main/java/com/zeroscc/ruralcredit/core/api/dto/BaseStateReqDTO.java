package com.zeroscc.ruralcredit.core.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 通用状态请求类，用于修改状态什么的
 * </p>
 *
 * @author 聪明笨狗
 * @since 2019-04-20 12:15
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
public class BaseStateReqDTO extends BaseDTO {


    private List<String> ids;

    private Integer state;
}
