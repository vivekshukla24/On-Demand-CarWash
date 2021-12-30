package CG.washer.controller;

import CG.washer.model.OrderDetails;
import CG.washer.service.WasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** This Controller has two permanent washers that should not be deleted
 * -> WasherDetails(joel@gmail.com,"Joel","joel123")
 * -> WasherDetails(kenny@gmail.com,"Kenny","kenny345")
 * -> WasherDetails(james@gmail.com,"James","james987")
 * Both will be used to test wrapper classes for washer and rating integration */


@RestController
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WasherService wr;

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
    //To see the cancelled orders
    @GetMapping("/cancelledOrders")
    public List<OrderDetails> getCancelledOrders(){
        return wr.getCancelledOrders();
    }
    //To see the Unassigned orders
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return wr.getUnassignedOrders();
    }
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
        return wr.updateStatus(orderDetails);
    }
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public OrderDetails assignSelf(@RequestBody OrderDetails orderDetails){
        return wr.assignSelf(orderDetails);
    }

}
