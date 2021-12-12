package CG.admin.controller;

import CG.admin.model.AdminDetails;
import CG.admin.model.OrderDetails;
import CG.admin.model.WashPacks;
import CG.admin.WrapperModel.WasherRatings;
import CG.admin.service.AdminService;
import CG.admin.service.WashPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/admins")
public class AdminController{
    @Autowired
    AdminService as;
    @Autowired
    WashPackService wps;

    //These are all the admin model controls
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

    //These are all the WashPacks Controls
    @GetMapping("/findallWP")
    public List<WashPacks> findallWP(){
        return wps.findallWP();
    }
    @GetMapping("/findoneWP/{id}")
    public WashPacks findoneWP(@PathVariable int id){
        return wps.findoneWP(id);
    }
    @PostMapping("/addWP")
    public WashPacks addWP(@RequestBody WashPacks washPacks){
        return wps.addWP(washPacks);
    }
    @DeleteMapping("/deleteWP/{id}")
    public String deleteWP(@PathVariable int id){
        return wps.deleteWP(id);
    }
    @PutMapping("/updateWP")
    public WashPacks updateWP(@RequestBody WashPacks washPacks){
        return wps.updateWP(washPacks);
    }

    /** Only the methods that use rest template are below this comment **/

    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
       return as.updateStatus(orderDetails);
    }

    /** To get all the orders using rest template from Order Microservice **/
    @GetMapping("/allOrders")
    public List<OrderDetails> getallOrders(){
        return as.getallOrders();
    }

    //To see the completed orders
    @GetMapping("/completedOrders")
    public List<OrderDetails> getCompletedOrders(){
        return as.getCompletedOrders();
    }

    //To see the pending orders
    @GetMapping("/pendingOrders")
    public List<OrderDetails> getPendingOrders(){
        return as.getPendingOrders();
    }

    //To see the cancelled orders
    @GetMapping("/cancelledOrders")
    public List<OrderDetails> getCancelledOrders(){
        return as.getCancelledOrders();
    }

    //To delete the order from admin's end
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        return as.deleteOrder(id);
    }

    //To get the details of Washers with all their reviews
    @GetMapping("/washerRating/{name}")
    public WasherRatings washerSpecificRatings(@PathVariable String name){
        return as.washerSpecificRatings(name);
    }
}

