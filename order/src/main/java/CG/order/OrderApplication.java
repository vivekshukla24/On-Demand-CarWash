package CG.order;

import CG.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderApplication{
	@Autowired
	private OrderRepo or;
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
