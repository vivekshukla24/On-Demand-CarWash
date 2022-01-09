package CG.user;

import CG.user.Repository.RatingRepo;
import CG.user.model.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
@Configuration
public class UserApplication implements CommandLineRunner {
	@Autowired
	private RatingRepo rr;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfig(){
		//Returns a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/users/**"))
				.apis(RequestHandlerSelectors.basePackage("CG.user"))
				.build()
				.apiInfo(apiinform());

	}
	private ApiInfo apiinform(){
		return new ApiInfo(
				"User's Panel",
				"The User has all the below controls",
				"1.0",
				"Can be used by anyone testing the app",
				new springfox.documentation.service.Contact("Vivek Shukla","https://github.com/vivekshukla24","vivek@gmail.com"),
				"API license",
				"https://github.com/vivekshukla24",
				Collections.emptyList());

	}

	@Override
	public void run(String... args) throws Exception {
		if(rr.findAll().isEmpty()){
			rr.save(new Ratings(1,"Kenny","Really good experience with kenny, my car is clean",8));
			rr.save(new Ratings(2,"Kenny","Really good job on my car",9));
			rr.save(new Ratings(3,"Joel","Really good experience with Joel, my car is clean",7));
			rr.save(new Ratings(4,"Joel","Really good job, my looks good as new",9));
		}
	}
	//Cross-origin configuration for angular
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
