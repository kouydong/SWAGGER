package com.example.swagger.dto.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.RegExp;

@Setter
@Getter
//─────────────────────────────────────────────────────────────────────────────────────────────
//  기능 : Swqgger 어노테이션으로 Request에 어떤 값들이 들어가는지 설정하기 위한 메타 어노테이션 (3.0에서는 작동하지 않음)
//  영역 : 클래스 및 매서드
//─────────────────────────────────────────────────────────────────────────────────────────────
//@Schema(description = "아파트아이모듈 RequestBody")
public class SwaggerReqDto {

    @ApiModelProperty(example="12345")
    private String aptCd;

    @ApiModelProperty(example="jkjkljkljvklxj90eru")
    private String userId;

    private String notUsedParameter3;

}
