package com.tencent.bbm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: config swagger
 * @author: bbm
 * @Date: 2020/5/1 4:49 下午
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置api
     * @return result
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tencent.bbm.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api 配置
     * @return result
     */
    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("消息中心")
                .description("v1.0")
                .version("1.0")
                .build();
    }
}
