package com.zeroscc.ruralcredit.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.List;


@Data

public class BaseIdsReqDTO extends BaseDTO {


    @JsonIgnore
    private String userId;

    private List<String> ids;
}
