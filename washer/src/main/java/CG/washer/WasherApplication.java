package CG.washer;

import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;
@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class WasherApplication implements CommandLineRunner {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private WasherRepository wr;
	public static void main(String[] args) {
		SpringApplication.run(WasherApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfig(){
		//Returns a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/washers/**"))
				.apis(RequestHandlerSelectors.basePackage("CG.washer"))
				.build()
				.apiInfo(apiinform());

	}
	private ApiInfo apiinform(){
		return new ApiInfo(
				"Washer's Panel",
				"The Washer has all the below controls",
				"1.0",
				"Can be used by anyone testing the app",
				new springfox.documentation.service.Contact("Vivek Shukla","https://github.com/vivekshukla24","vivek@gmail.com"),
				"API license",
				"https://github.com/vivekshukla24",
				Collections.emptyList());
	}

	@Override
	public void run(String... args) throws Exception {
		if(wr.findAll().isEmpty()){
			wr.save(new WasherDetails(1,"Joel","joel123"));
			wr.save(new WasherDetails(2,"Kenny","kenny345"));
		}
	}
}

