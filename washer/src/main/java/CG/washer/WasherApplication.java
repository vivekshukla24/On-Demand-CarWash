package CG.washer;

import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WasherApplication implements CommandLineRunner {
	@Autowired
	private WasherRepository wr;
	public static void main(String[] args) {
		SpringApplication.run(WasherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(wr.findAll().isEmpty()){
			wr.save(new WasherDetails(1,"dummy","dummy","dummy"));
		}
	}
}
