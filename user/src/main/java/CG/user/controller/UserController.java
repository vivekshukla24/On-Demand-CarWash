package CG.user.controller;

import CG.user.model.Car;
import CG.user.model.OrderDetails;
import CG.user.model.UserDetails;
import CG.user.service.carService;
import CG.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private userService us;
    @Autowired
    private carService cs;

    //Url to access the methods of Order Service
    String url="http://localhost:8082/orders";

    //To get all the users
    @GetMapping("/findall")
    public List<UserDetails> findallUsers(){
        return us.findallUsers();
    }
    //To add a car
    @PostMapping("/addcar")
    public Car addCar(@RequestBody Car car){
        return cs.addCar(car);
    }
    //To find one car
    @GetMapping("/findoneCar/{id}")
    public Car findonecar(@PathVariable int id){
        return cs.findoneCar(id);
    }
    //To delete a car
    @DeleteMapping("/deletecar/{id}")
    public String deletemyCar(@PathVariable int id){
        return cs.deleteCar(id);
    }
    //To find a user by id
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
    //To add an order at User-end
    @PostMapping("/addOrder")
    public OrderDetails addOrder(@RequestBody OrderDetails orderDetails){
        HttpEntity<OrderDetails> addOrderbyUser = new HttpEntity<>(orderDetails);
        OrderDetails od=restTemplate.postForObject(url+"/add",addOrderbyUser,OrderDetails.class);
        return od;
    }
}
