package CG.admin;

import CG.admin.model.AdminDetails;
import CG.admin.model.Car;
import CG.admin.model.Ratings;
import CG.admin.model.WashPacks;
import CG.admin.repository.AdminRepo;
import CG.admin.repository.CarRepo;
import CG.admin.repository.RatingRepo;
import CG.admin.repository.WashPackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdminApplication implements CommandLineRunner {
	@Autowired
	private AdminRepo ar;
	@Autowired
	private CarRepo cr;
	@Autowired
	private RatingRepo rr;
	@Autowired
	private WashPackRepo wpr;

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(ar.findAll().isEmpty()){
			ar.save(new AdminDetails(1,"dummy"));
		}
		if(cr.findAll().isEmpty()){
			cr.save(new Car(1,"Honda","Active"));
		}
		if(rr.findAll().isEmpty()){
			rr.save(new Ratings(1,"dummy","nocom"));
		}
		if(wpr.findAll().isEmpty()){
			wpr.save(new WashPacks(1,"dummy",000,"desc"));
		}
	}
}
