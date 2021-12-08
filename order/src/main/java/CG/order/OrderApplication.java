package CG.order;

import CG.order.model.OrderDetails;
import CG.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {
	@Autowired
	private OrderRepo or;
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (or.findAll().isEmpty()){
			or.save(new OrderDetails(1,"dummy","dummy",3,56,9911,"Pending"));
		}
	}
}
