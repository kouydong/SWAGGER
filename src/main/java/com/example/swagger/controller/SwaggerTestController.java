package com.example.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.swagger.dto.req.SwaggerReqDto;
import springfox.documentation.annotations.ApiIgnore;



@RestController
public class SwaggerTestController {
    @PostMapping("/swaggerTest")
    //─────────────────────────────────────────────────────────────────────────
    //  기능 : Controller안의 파라미터 설명시 사용 => @ApiImplicitParam 인터페이스 어노테이션 구현 필요
    //─────────────────────────────────────────────────────────────────────────
    @ApiImplicitParams(
            {
                    //─────────────────────────────────────────────────────────────────────────
                    //  기능 : Controller안의 파라미터 설명시 사용 => @ApiImplicitParam 인터페이스 어노테이션 구현 필요
                    //─────────────────────────────────────────────────────────────────────────
                    //  속성값
                    //─────────────────────────────────────────────────────────────────────────
                    //  name  : 파라미터 이름 설정
                    //  value : 파라미터의 값 설정
                    //─────────────────────────────────────────────────────────────────────────
                    @ApiImplicitParam(name = "aptCd" , value = "아파트코드5자리"),
                    @ApiImplicitParam(name = "userId", value = "암호화유저아이디")
            })
    //─────────────────────────────────────────────────────────────────────────
    //  기능 : Controller안의 메서드 설명시 사용
    //─────────────────────────────────────────────────────────────────────────
    //  속성값
    //─────────────────────────────────────────────────────────────────────────
    //  summary     : 메소드가 무슨 기능을 하는지 요약 정의
    //  description : 메소드가 무슨 기능을 하는지에 대한 상세 정의
    //─────────────────────────────────────────────────────────────────────────
    @Operation(summary = "스웨거테스트", description ="사용자 정보 조회")
    //─────────────────────────────────────────────────────────────────────────
    //  기능 : Swagger API 메서드의 출력되지 않도록 설정
    //─────────────────────────────────────────────────────────────────────────
    //@ApiIgnore

    //─────────────────────────────────────────────────────────────────────────
    //  기능 : 그룹핑하는 어노테이션으로 name 속성이 같은 것끼리 API그룹으로 묶음
    //  지정영역 : Class or Method
    //─────────────────────────────────────────────────────────────────────────
    //@Tag(name="MyController", description = "사용자 API")

    public String getTestApi(@RequestBody SwaggerReqDto reqDto) {

        String aptCd    = reqDto.getAptCd();
        String userId   = reqDto.getUserId();

        String jsonStr  = "{" +
                        "\"aptCd\" : \""+aptCd+"\"," +
                        "\"userId\" : \""+userId+"\"" +
                        "}";
        return jsonStr;
    }
}
