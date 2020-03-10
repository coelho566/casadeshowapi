package br.com.gft.casadeshowapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.gft.casadeshowapi.resources"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .tags(new Tag("Casas", "Gerencia as casas"), new Tag("Eventos", "Gerencia os eventos"), new Tag("Usuários", "Gerencia os usuários"), new Tag("Vendas", "Gerencia as vendas"))
          ;
          
    }
    
    public ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			.title("Casa de show API")
    			.description("API aberta para casa de shows e eventos")
    			.version("1")
    			.build();
    }
}
