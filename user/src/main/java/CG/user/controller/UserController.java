package CG.user.controller;

import CG.user.model.OrderDetails;
import CG.user.model.UserDetails;
import CG.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private userService us;

    //To get all the users
    @GetMapping("/findall")
    public List<UserDetails> findallUsers(){
        return us.findallUsers();
    }
    //To add a car
    @GetMapping("/findoneuser/{id}")
    public UserDetails findoneUser(@PathVariable int id){
        return us.findoneUser(id);
    }
    //To add a user
    @PostMapping("/adduser")
    public UserDetails addUser(@RequestBody UserDetails userDetails) {
        return us.addUser(userDetails);
    }
    //To delete a user
    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable int id){
        return us.deleteUser(id);
    }
    //To update a user
    @PutMapping("/updateuser")
    public UserDetails updateuser(@RequestBody UserDetails userDetails){
        return us.updateuser(userDetails);
    }

    /** Only the methods that use rest template are below this comment**/

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
    @PutMapping("/cancelOrder")
    public String cancelOrder(@RequestBody OrderDetails orderDetails){
        return us.cancelOrder(orderDetails);
    }

//    @DeleteMapping("/deleteOrder/{id}")
//    public String deleteOrder(@PathVariable int id){
//        return us.deleteOrder(id);
//    }
}
