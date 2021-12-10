package CG.user.service;

import CG.user.Repository.UserRepository;
import CG.user.exceptionHandlers.API_requestException;
import CG.user.model.OrderDetails;
import CG.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


@Service
public class userService {
    @Autowired
    private RestTemplate restTemplate;
    //Url to access the methods of Order Service

    String url="http://localhost:9000/orders";
    @Autowired
    private UserRepository ur;

    //To get all the users
    public List<UserDetails> findallUsers(){
        return ur.findAll();
    }
    //To find a user by id
    public UserDetails findoneUser(int id){
        return ur.findById(id).get();
    }
    //To add a user
    public UserDetails addUser(UserDetails userDetails) {
        return ur.save(userDetails);
    }
    //To delete a user
    public String deleteUser(int id){
        boolean doesUserExists=ur.existsById(id);
        if(doesUserExists){
            ur.deleteById(id);
            return "User with ID "+id+" deleted successfully";
        }
        else {
            throw new API_requestException("User not found, deletion failed");
        }
    }
    //To update a user
    public UserDetails updateuser(UserDetails userDetails){
        boolean doesUserExists=ur.existsById(userDetails.getId());
        if (doesUserExists){
            UserDetails existingUser= ur.findById(userDetails.getId()).orElse(null);
            existingUser.setName(userDetails.getName());
            existingUser.setLocation(userDetails.getLocation());
            existingUser.setPassword(userDetails.getPassword());
            return ur.save(existingUser);
        }
        else {
            throw new API_requestException("User not found in database, update failed");
        }
    }

    /** Only the methods that use rest template are below this comment**/

    //To add an order from User-end
    public OrderDetails addOrder(OrderDetails orderDetails){
        HttpEntity<OrderDetails> addOrderbyUser = new HttpEntity<>(orderDetails);
        OrderDetails od=restTemplate.postForObject(url+"/add",addOrderbyUser,OrderDetails.class);
        return od;
    }

    //To update and order from User-end
    //This won't update the status of order
    public OrderDetails updateOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"/update", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
        return od;
    }

}
