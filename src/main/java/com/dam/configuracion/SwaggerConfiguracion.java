package com.dam.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase para la configuración de Swagger UI.
 * 
 * @author Daniel Versión 1.0
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguracion {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.dam.controladores")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API DOCUMENTACIÓN").description("DESARROLLO DE UNA API REST CON SPRING BOOT")
				.version("1.0").contact(new Contact("Daniel Pompa Pareja", " ", "example@gmail.com")).build();
	}
}
