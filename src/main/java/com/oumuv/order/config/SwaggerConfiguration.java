package com.oumuv.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 *<pre>
 *  SwaggerConfiguration
 *</pre>
 * @ClassName: SwaggerConfiguration
 * @Auther: oyf
 * @Date: 2019-03-07 16:07
 * @version : V1.0
 */
@Configuration
@EnableSwagger2//开启swagger
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.oumuv.order"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful API")
                .description("springboot搭建的小型的订单系统")
                .termsOfServiceUrl("http://www.oumuv.xin/")
                .contact("Oumuv")
                .version("1.0")
                .build();
    }
}
