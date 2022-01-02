package CG.washer.service;

import CG.washer.model.OrderDetails;
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
public class WasherService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    String url="http://ORDER-SERVICE/orders";

    /** Only the methods that use rest template are below this comment **/
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
        OrderDetails[] unassignedList = restTemplate.getForObject(url+"/findUnassigned",OrderDetails[].class);
        return Arrays.asList(unassignedList);
    }
    //To update the status of the order by Washer
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/updateStatus", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
    }
    //To assign a washer to the order by washer
    public OrderDetails assignSelf(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
    }
}
