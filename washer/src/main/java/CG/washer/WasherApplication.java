package CG.washer;

import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class WasherApplication implements CommandLineRunner {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	private WasherRepository wr;
	public static void main(String[] args) {
		SpringApplication.run(WasherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(wr.findAll().isEmpty()){
			wr.save(new WasherDetails(1,"Joel","joel123"));
			wr.save(new WasherDetails(2,"Kenny","kenny345"));
		}
	}
}
