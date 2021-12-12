package CG.admin;

import CG.admin.model.AdminDetails;
import CG.admin.model.WashPacks;
import CG.admin.repository.AdminRepo;
import CG.admin.repository.WashPackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class AdminApplication implements CommandLineRunner {
	@Autowired
	private AdminRepo ar;
	@Autowired
	private WashPackRepo wpr;
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(ar.findAll().isEmpty()){
			ar.save(new AdminDetails(1,"dummy","dummy"));
		}
		if(wpr.findAll().isEmpty()){
			wpr.save(new WashPacks(1,"All clean pack",2500,"Interior cleaning, Exterior cleaning, Mats cleaning, polishing"));
			wpr.save(new WashPacks(2,"Selective Pack",1500,"Interior cleaning, Exterior cleaning"));
		}
	}
}
