package CG.admin.controller;

import CG.admin.model.AdminDetails;
import CG.admin.model.OrderDetails;
import CG.admin.repository.RatingRepo;
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

    @GetMapping("/findallAdmins")
    public List<AdminDetails> findallAdmins() {
        return as.findallAdmins();
    }
    @GetMapping("/findoneAdmin/{id}")
    public AdminDetails findoneAdmin(@PathVariable int id){
        return as.findoneAdmin(id);
    }
    @PostMapping("/addAdmin")
    public AdminDetails addAdmin(@RequestBody AdminDetails adminDetails){
        return as.addAdmin(adminDetails);
    }
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable int id){
        return as.deleteAdmin(id);
    }
    @PutMapping("/updateAdmin")
    public AdminDetails updateAdmin(@RequestBody AdminDetails adminDetails){
        return as.updateAdmin(adminDetails);
    }

    /** The status of the order can be either pending or completed **/
    @PutMapping("/updateStatus")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
       return as.updateStatus(orderDetails);
    }
}

