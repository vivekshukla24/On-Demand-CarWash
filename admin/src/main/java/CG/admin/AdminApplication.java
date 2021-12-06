package CG.admin;

import CG.admin.model.AdminDetails;
import CG.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdminApplication implements CommandLineRunner {
	@Autowired
	private AdminRepo ar;
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(ar.findAll().isEmpty()){
			ar.save(new AdminDetails(1,"dummy"));
		}
	}
}
