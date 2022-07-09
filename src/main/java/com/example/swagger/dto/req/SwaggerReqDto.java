package com.example.swagger.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SwaggerReqDto {

    @ApiModelProperty(example="12345")
    private String aptCd;

    @ApiModelProperty(example="jkjkljkljvklxj90eru")
    private String userId;

    private String notUsedParameter3;

}
