package CG.admin.service;

import CG.admin.WrapperModel.WasherRatings;
import CG.admin.exceptionHandlers.API_requestException;
import CG.admin.model.*;
import CG.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    String url="http://ORDER-SERVICE/orders";
    //Url to access the methods of User Service
    String url2="http://USER-SERVICE/users";
    //Url to access the methods of Zuul Service
    String url4="http://ZUUL-SECURITY/manage";

    /** 1) Only the methods that respond to rest templates are below this comment
        2) User controls through admin using rest template */
    //To get the list of all the Admins using rest template
    public List<User> getAllAdmins(){
        User[] washerDetailList=restTemplate.getForObject(url4+"/users/"+"ADMIN",User[].class);
        return Arrays.asList(washerDetailList);
    }
    //To get all the users
    public List<User> getAllUsers(){
        User[] userDetailList=restTemplate.getForObject(url4+"/users/"+"USER",User[].class);
        return Arrays.asList(userDetailList);
    }
    /** Order controls through admin using rest template*/
    //To update the status of the order
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/updateStatus", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
    }
    //To assign a washer to the order by Admin
    public OrderDetails assignWasher(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
    }
    //To get all the orders
    public List<OrderDetails> getallOrders(){
        OrderDetails[] od= restTemplate.getForObject(url+"/findall", OrderDetails[].class);
        if(Arrays.asList(od).isEmpty()){
            throw new API_requestException("There are no orders in the DB");
        }
        else {
            return Arrays.asList(od);
        }
    }
    //To see the completed orders
    public List<OrderDetails> getCompletedOrders(){
        OrderDetails[] completedList = restTemplate.getForObject(url+"/findCompleted",OrderDetails[].class);
        return Arrays.asList(completedList);
    }
    //To see the pending orders
    public List<OrderDetails> getPendingOrders(){
        OrderDetails[] pendingList = restTemplate.getForObject(url+"/findPending",OrderDetails[].class);
        return Arrays.asList(pendingList);
    }
    //To see the cancelled orders
    public List<OrderDetails> getCancelledOrders(){
        OrderDetails[] cancelledList = restTemplate.getForObject(url+"/findCancelled",OrderDetails[].class);
        return Arrays.asList(cancelledList);
    }
    //To see the Unassigned orders
    public List<OrderDetails> getUnassignedOrders(){
        OrderDetails[] cancelledList = restTemplate.getForObject(url+"/findUnassigned",OrderDetails[].class);
        return Arrays.asList(cancelledList);
    }
    //To delete an Order from Admin's-end
    public String deleteOrder(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> deleteOrder = new HttpEntity<>(headers);
        ResponseEntity<String> response=restTemplate.exchange(url+"/delete/"+id,HttpMethod.DELETE,deleteOrder,String.class);
        return response.getBody();
    }
    /** Washer controls through admin using rest template*/
    //To get the list of all the washers using rest template
    public List<User> getAllWashers(){
        User[] washerDetailList=restTemplate.getForObject(url4+"/users/"+"WASHER",User[].class);
        return Arrays.asList(washerDetailList);
    }
    //To get a single washer
    public User getOneWasher(String name){
        return restTemplate.getForObject(url4+"/washer/"+name,User.class);
    }
    //To get the details of Washers with all their reviews
    public WasherRatings washerSpecificRatings(String washerName){
        //Using a wrapper-class here to get 2 json in one
        User wd =restTemplate.getForObject(url4+"/washer/"+washerName,User.class);
        Ratings[] ratingsList=restTemplate.getForObject(url2+"/washerSpecificRating/"+washerName,Ratings[].class);
        //Wrapping into a "Proxy class"
        return new WasherRatings(wd.getId(),wd.getFullname(),wd.getEmail(),Arrays.asList(ratingsList));
    }
}
