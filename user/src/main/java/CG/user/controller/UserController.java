package CG.user.controller;

import CG.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository ur;

    @RequestMapping("/u")
    public String hello() {
        return "Hello user";
    }

}
