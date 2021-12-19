package CG.washer.controller;

import CG.washer.model.OrderDetails;
import CG.washer.model.WasherDetails;
import CG.washer.service.WasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** This Controller has two permanent washers that should not be deleted
 * WasherDetails(1,"Joel","joel123")
 * WasherDetails(2,"Kenny","kenny345")
 * Both will be used to test wrapper classes for washer and rating integration */


@RestController
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WasherService wr;

    //To find all users
    @GetMapping("/findallWasher")
    public List<WasherDetails> findallWashers(){
        return wr.findallWashers();
    }
    //To find one washer with ID
    @GetMapping("/findoneWasher/{id}")
    public WasherDetails findoneWasher(@PathVariable int id){
        return wr.findoneWasher(id);
    }
    @GetMapping("/findbyname/{name}")
    public WasherDetails findbyname(@PathVariable String name){
        return wr.findOnebyName(name);
    }
    //To add a new Washer
    @PostMapping("/addWasher")
    public WasherDetails addWasher(@RequestBody WasherDetails washerDetails) {
        return wr.addWasher(washerDetails);
    }
    //To delete a washer
    @DeleteMapping("/deleteWasher/{id}")
    public String deleteWasher(@PathVariable int id){
        return wr.deleteWasher(id);
    }
    //To update a washer
    @PutMapping("/updateWasher")
    public WasherDetails updateWasher(@RequestBody WasherDetails washerDetails){
        return wr.updateWasher(washerDetails);
    }

    /** Only the methods that consume rest template are below this comment **/
    //To see the completed orders
    @GetMapping("/completedOrders")
    public List<OrderDetails> getCompletedOrders(){
        return wr.getCompletedOrders();
    }
    //To see the pending orders
    @GetMapping("/pendingOrders")
    public List<OrderDetails> getPendingOrders(){
        return wr.getPendingOrders();
    }
    @GetMapping("/cancelledOrders")
    public List<OrderDetails> getCancelledOrders(){
        return wr.getCancelledOrders();
    }
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return wr.getUnassignedOrders();
    }
}
