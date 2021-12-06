package CG.order.controller;

import CG.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepo or;

    @RequestMapping("/o")
    public String hello(){
        return "Hello Order";
    }
}
