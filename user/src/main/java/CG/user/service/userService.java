package CG.user.service;

import CG.user.WrapperModel.OrderReceipt;
import CG.user.exceptionHandlers.API_requestException;
import CG.user.model.OrderDetails;
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

    //Url to access the methods of Order Service
    String url="http://ORDER-SERVICE/orders";
    //Url to access the methods of admin Service
    String url1="http://ADMIN-SERVICE/admins";

    //To see all the WashPacks
    public List<WashPacks> getAllWP(){
        WashPacks[] wp=restTemplate.getForObject(url1+"/findallWP",WashPacks[].class);
        return (Arrays.asList(wp));
    }

    /** Only the methods that use rest template are below this comment**/
    //To add an order from User-end
    public OrderDetails addOrder(OrderDetails orderDetails){
        HttpEntity<OrderDetails> addOrderbyUser = new HttpEntity<>(orderDetails);
        return restTemplate.postForObject(url+"/add",addOrderbyUser,OrderDetails.class);
    }
    //To update an order from User-end
    //This won't update the status of order
    public OrderDetails updateOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/update", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
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
    public OrderReceipt getReceipt(String id){
        OrderDetails od=restTemplate.getForObject(url+"/findone/"+id,OrderDetails.class);
        WashPacks wp=restTemplate.getForObject(url1+"/wpbyname/"+od.getWashpack(),WashPacks.class);
        if(od.getStatus().contains("Completed")){
            return new OrderReceipt(id,od.getUseremailid(),od.getWasherName(),wp.getName(),wp.getDescription(),wp.getCost());
        }
        else{
            throw new API_requestException("Your order with ID -> "+id+" is still pending");
        }
    }
}
