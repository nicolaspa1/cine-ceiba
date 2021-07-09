package com.ceiba.infraestructura.configuracion;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfiguracionSwagger {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.consumes(Sets.newHashSet("application/json")).produces(Sets.newHashSet("application/json")).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build();
	}

	private static ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Documentacion ApiRest").description("Descripcion de los servicios rest de la aplicacion")
				.version("1.0").contact(new Contact("Ceiba Software House", null, "contacto@ceiba.com.co")).build();
	}
}