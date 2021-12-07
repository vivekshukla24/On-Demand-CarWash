package CG.admin.controller;

import CG.admin.model.AdminDetails;
import CG.admin.repository.AdminRepo;
import CG.admin.repository.RatingRepo;
import CG.admin.repository.WashPackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableEurekaClient
@RestController
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private AdminRepo ar;
    @Autowired
    private RatingRepo rr;
    @Autowired
    private WashPackRepo wr;

    @GetMapping("/findall")
    public List<AdminDetails> Alladmins(){
        return ar.findAll();
    }

}

