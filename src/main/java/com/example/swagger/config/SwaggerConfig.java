package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    //─────────────────────────────────────────────────────────────────────────────────────────────
    // Swagger 기본 설정
    //─────────────────────────────────────────────────────────────────────────────────────────────
    @Bean
    public Docket swaggerApi() {
        // Swagger API 2.0대일 경우 'OAS_30' 대신 'SWAGGER_2' 사용
        return new Docket(DocumentationType.OAS_30)
                // Request애 대한 메타 데이터 정보 설정
                .consumes(getConsumeContentTypes())
                // Response에 대한 메타 데이터 정보 설정
                .produces(getProduceContentTypes())
                // Swagger의 일반적인 정보를 담는 메서드로 ApiInfo 객체를 리턴
                .apiInfo(getSwaggerInfo())
                // ApiInfo로 반환된 객체를 선택
                .select()
                // REST API문서로 만들기 위한 기본 패키지 설정
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger"))
                // 경로 설정
                .paths(PathSelectors.ant("/**")) //PathSelectors.any() 와 동일
                .build()
                // Response에 기본 메시지 사용 여부(기본값 : false)
                .useDefaultResponseMessages(false);
    }
    //─────────────────────────────────────────────────────────────────────────────────────────────
    //  기능 : Swagger의 일반적인 정보를 담는 메서드로 ApiInfo 객체를 리턴
    //─────────────────────────────────────────────────────────────────────────────────────────────
    private ApiInfo getSwaggerInfo() {
        return new ApiInfoBuilder()
                // Swagger API main title 설정
                .title("Swagger Test API ")
                // Swagger API main 부연 설명
                .description("Swagger Test API입니다.")
                // Swagger API version 설정
                .version("1.0")
                .build();
    }
    //─────────────────────────────────────────────────────────────────────────────────────────────
    //  기능 : Request애 대한 메타 데이터 정보 설정
    //─────────────────────────────────────────────────────────────────────────────────────────────
    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    //─────────────────────────────────────────────────────────────────────────────────────────────
    //  기능 : Response 대한 메타 데이터 정보 설정
    //─────────────────────────────────────────────────────────────────────────────────────────────
    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }


/*
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
 */

}
