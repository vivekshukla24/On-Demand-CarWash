package CG.user;

import CG.user.Repository.RatingRepo;
import CG.user.Repository.UserRepository;
import CG.user.model.Ratings;
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
	@Autowired
	private RatingRepo rr;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(ur.findAll().isEmpty()){
			ur.save(new UserDetails(1,"dummy","dummy","dummy"));
		}
		if(rr.findAll().isEmpty()){
			rr.save(new Ratings(1,"Kenny","Really good experience with kenny, my car is clean",8));
			rr.save(new Ratings(2,"Kenny","Really good job on my car",9));
			rr.save(new Ratings(3,"Joel","Really good experience with Joel, my car is clean",7));
			rr.save(new Ratings(4,"Joel","Really good job, my looks good as new",9));
		}
	}
}
