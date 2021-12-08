package CG.user;

import CG.user.Repository.CarRepo;
import CG.user.Repository.UserRepository;
import CG.user.model.Car;
import CG.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class UserApplication implements CommandLineRunner {
	@Autowired
	private UserRepository ur;
	@Bean
	public RestTemplate getRestTemplate() {return new RestTemplate();}
	@Autowired
	private CarRepo cr;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(ur.findAll().isEmpty()){
			ur.save(new UserDetails(1,"dummy","dummy","dummy"));
		}
		if(cr.findAll().isEmpty()){
			cr.save(new Car(1,"Honda"));
		}
	}
}