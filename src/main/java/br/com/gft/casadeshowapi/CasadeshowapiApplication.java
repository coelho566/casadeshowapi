package br.com.gft.casadeshowapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CasadeshowapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadeshowapiApplication.class, args);
	}

}
