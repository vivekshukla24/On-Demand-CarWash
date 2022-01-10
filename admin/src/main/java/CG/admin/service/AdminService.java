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


    /** Order controls through admin using rest template*/
    //To assign a washer to the order by Admin
    public OrderDetails assignWasher(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
    }

    /** Washer controls through admin using rest template*/
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
