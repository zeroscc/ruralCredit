package com.zeroscc.ruralcredit.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class BaseIdReqDTO extends BaseDTO {


    private String id;

    @JsonIgnore
    private String userId;

}
