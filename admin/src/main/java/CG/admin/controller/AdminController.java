package CG.admin.controller;

import CG.admin.model.*;
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

    /** Washer controls through admin using service object */
    //To find all the washpack
    @GetMapping("/findallWP")
    public List<WashPacks> findallWP(){
        return wps.findallWP();
    }
    //To find one WashPack with ID
    @GetMapping("/findoneWP/{id}")
    public WashPacks findoneWP(@PathVariable int id){
        return wps.findoneWP(id);
    }
    //To add a new WashPack
    @PostMapping("/addWP")
    public WashPacks addWP(@RequestBody WashPacks washPacks){
        return wps.addWP(washPacks);
    }
    //To delete a Washpack
    @DeleteMapping("/deleteWP/{id}")
    public String deleteWP(@PathVariable int id){
        return wps.deleteWP(id);
    }
    //To update a Washpack
    @PutMapping("/updateWP")
    public WashPacks updateWP(@RequestBody WashPacks washPacks){
        return wps.updateWP(washPacks);
    }


    /** Only the methods that use rest template are below this comment */
    //To get the list of all users
    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return as.getAllUsers();
    }

    /** Order controls through admin using rest template */
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus")
    public OrderDetails updateStatusOrder(@RequestBody OrderDetails orderDetails){
       return as.updateStatus(orderDetails);
    }
    //To assign a washer to the order by Admin
    @PutMapping("/assignWasher")
    public OrderDetails assignWasher(@RequestBody OrderDetails orderDetails){
        return as.assignWasher(orderDetails);
    }
    // To get all the orders using rest template from Order Microservice
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
    //To delete the order from admin's-end
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id){
        return as.deleteOrder(id);
    }

    /** Washer controls through admin using rest template */
    //To get the details of Washers with all their reviews
    @GetMapping("/allWashers")
    public List<User> getAllWashers(){
        return as.getAllWashers();
    }
    //To get one washer
    @GetMapping("/oneWasher/{name}")
    public User getOneWasher(@PathVariable String name){
        return as.getOneWasher(name);
    }
    //To get all the ratings of a specific Washer
    @GetMapping("/washerRating/{name}")
    public WasherRatings washerSpecificRatings(@PathVariable String name){
        return as.washerSpecificRatings(name);
    }
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return as.getUnassignedOrders();
    }
}

