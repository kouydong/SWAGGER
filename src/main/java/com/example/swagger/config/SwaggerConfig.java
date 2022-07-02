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
                // 사용자 정의 메서드 설정
                .consumes(getConsumeContentTypes())
                // 사용자 정의 메서드 설정
                .produces(getProduceContentTypes())
                // 사용자 정의 함수 설정
                .apiInfo(getSwaggerInfo()).select()
                // 베이스 패키지 설정
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger"))
                // 경로 설정
                //PathSelectors.any() 와 동일
                .paths(PathSelectors.ant("/**"))
                .build()
                // 디폴트 메시지 설정
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getSwaggerInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Test API ")             // Swagger API main title 설정
                .description("Swagger Test API입니다.")  // Swagger API main 부연 설명
                .version("1.0")                         // Swagger API version 설정
                .build();
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

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
