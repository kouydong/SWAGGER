package com.example.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
                    //  name : 파라미터 이름 설정
                    //  value : 파라미터의 값 설정
                    //─────────────────────────────────────────────────────────────────────────
                    @ApiImplicitParam(name = "aptCd" , value = "아파트코드5자리"),
                    @ApiImplicitParam(name = "userId", value = "암호화유저아이디")
            }
            )
    //─────────────────────────────────────────────────────────────────────────
    //  기능 : Controller안의 메서드 설명시 사용
    //─────────────────────────────────────────────────────────────────────────
    //  속성값
    //─────────────────────────────────────────────────────────────────────────
    //  value : 메소드가 무슨 기능을 하는지 요약 정의
    //  notes : 메소드가 무슨 기능을 하는지에 대한 상세 정의
    //─────────────────────────────────────────────────────────────────────────
    @ApiOperation(value = "스웨거테스트", notes = "스웨거 명세화를 위한 API 테스트")
    //─────────────────────────────────────────────────────────────────────────
    //  기능 : Swagger API 메서드의 출력되지 않도록 설정
    //─────────────────────────────────────────────────────────────────────────
    //@ApiIgnore
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
