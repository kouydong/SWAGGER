package com.example.swagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.swagger.dto.req.SwaggerReqDto;

@RestController
//@ApiIgnore
@ApiOperation(value = "SwaggerTest", notes = "Swagger Test Description")

public class SwaggerTestController {

    @PostMapping("/swaggerTest")
    public String getTestApi(@RequestBody SwaggerReqDto reqDto) {

        String parameter1 = reqDto.getParameter1();
        String jsonStr = "{'parameter1' : '"+parameter1+"}'";

        return jsonStr;
    }
}
