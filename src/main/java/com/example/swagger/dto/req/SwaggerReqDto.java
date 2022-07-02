package com.example.swagger.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SwaggerReqDto {
    @ApiModelProperty(value = "테스트파리머트설정", example = "1234")
    private String parameter1;
}
