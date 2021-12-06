package CG.washer.controller;

import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@RequestMapping("/washer")
public class WasherController {
    @Autowired
    WasherRepository wr;

    @GetMapping("/w")
    public String hello(){
        return "Hello washer";
    }
}
