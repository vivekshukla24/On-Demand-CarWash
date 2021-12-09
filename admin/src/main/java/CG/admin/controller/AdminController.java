package CG.admin.controller;

import CG.admin.model.AdminDetails;
import CG.admin.model.OrderDetails;
import CG.admin.repository.AdminRepo;
import CG.admin.repository.RatingRepo;
import CG.admin.repository.WashPackRepo;
import CG.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admins")
public class AdminController{
    @Autowired
    AdminService as;
    @Autowired
    private RatingRepo rr;
    @Autowired
    private WashPackRepo wr;

    @PutMapping("/updateStatus")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
       return as.updateStatus(orderDetails);
    }
}

