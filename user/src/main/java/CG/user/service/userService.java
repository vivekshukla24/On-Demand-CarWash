package CG.user.service;

import CG.user.Repository.UserRepository;
import CG.user.WrapperModel.OrderReceipt;
import CG.user.exceptionHandlers.API_requestException;
import CG.user.model.OrderDetails;
import CG.user.model.UserDetails;
import CG.user.model.WashPacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


@Service
public class userService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository ur;

    //Url to access the methods of Order Service
    String url="http://ORDER-SERVICE/orders";
    //Url to access the methods of admin Service
    String url1="http://ADMIN-SERVICE/admins";


    //User can't find all Users so the all method will be vacant

    //To find a user by id
    public UserDetails findoneUser(int id){
        return ur.findById(id).get();
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
    //To update an order from User-end
    //This won't update the status of order
    public OrderDetails updateOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"/update", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
        return od;
    }
    //To cancel the Order from user end
    public String cancelOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> cancelledOrder = new HttpEntity<>(orderDetails,headers);
        ResponseEntity<String> response=restTemplate.exchange(url+"/cancelOrder",HttpMethod.PUT,cancelledOrder,String.class);
        return response.getBody();
    }
    //To get the receipt of the order after order is completed
    public OrderReceipt getReceipt(int id){
        OrderDetails od=restTemplate.getForObject(url+"/findone/"+id,OrderDetails.class);
        WashPacks wp=restTemplate.getForObject(url1+"/findoneWP/"+od.getWashpackId(),WashPacks.class);
        if(od.getStatus().contains("Completed")){
           int cars_count= (int) od.getCars().stream().count();
            return new OrderReceipt(id,od.getWasherName(),wp,"You had "+cars_count+" cars in total so your payable amount is :- ",cars_count* wp.getCost());
        }
        else{
            throw new API_requestException("Your order with ID -> "+id+" is still pending");
        }
    }
}
