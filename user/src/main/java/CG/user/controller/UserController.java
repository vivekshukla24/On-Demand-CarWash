package CG.user.controller;

import CG.user.WrapperModel.OrderReceipt;
import CG.user.model.OrderDetails;
import CG.user.model.Ratings;
import CG.user.model.WashPacks;
import CG.user.service.RatingsService;
import CG.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private userService us;
    @Autowired
    private RatingsService rs;

    /** Only User-end Rating controls below this **/
    //To add a rating from User-end
    @PostMapping("/addRating")
    public Ratings addRating(Ratings ratings){
        return rs.addRating(ratings);
    }
    //For user to see ratings to decide the service
    @GetMapping("/getallRatings")
    public List<Ratings> getallratings(){
        return rs.getallRatings();
    }
    //For user to check a washer's history to make informed decision
    @GetMapping("/washerSpecificRating/{washerName}")
    public List<Ratings> washerSpecificRating(@PathVariable String washerName){
        return rs.washerSpecific(washerName);
    }

    //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return us.getAllWP();
    }

    /** Only the methods that call rest-template methods from services are below this comment**/
    //To add an order from User-end
    @PostMapping("/addOrder")
    public OrderDetails addOrder(@RequestBody OrderDetails orderDetails){
        return us.addOrder(orderDetails);
    }
    //To update and order from User-end
    //This won't update the status of order
    @PutMapping("/updateOrder")
    public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails){
        return us.updateOrder(orderDetails);
    }
    //To cancel the Order from user end
    @PutMapping("/cancelOrder")
    public String cancelOrder(@RequestBody OrderDetails orderDetails){
        return us.cancelOrder(orderDetails);
    }
    //To get the receipt of the order after order is completed
    @GetMapping("/getReceipt/{id}")
    public OrderReceipt getReceipt(@PathVariable int id){
       return us.getReceipt(id);
    }
}
