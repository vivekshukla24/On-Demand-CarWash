package CG.washer.service;

import CG.washer.exceptionHandlers.API_requestException;
import CG.washer.model.OrderDetails;
import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class WasherService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    //Provided with the Port of Gateway API
    String url="http://localhost:9000/orders";

    @Autowired
    WasherRepository wr;

    //To find all washers
    public List<WasherDetails> findallWashers(){
        return wr.findAll();
    }
    //To find one washer with ID
    public WasherDetails findoneWasher(int id){
        return wr.findById(id).get();
    }
    //To add a new Washer
    public WasherDetails addWasher(WasherDetails washerDetails) {
        return wr.save(washerDetails);
    }
    //To get Washer by name
    public WasherDetails findOnebyName(String name){
        WasherDetails wd=wr.findAll().stream().filter(x -> x.getName().contains(name)).findFirst().get();
        return wd;
    }
    //To delete a washer
    public String deleteWasher(int id){
        boolean doesWasherExists=wr.existsById(id);
        if(doesWasherExists){
            wr.deleteById(id);
            return "Washer with "+id+" deleted successfully";
        }
        else {
            throw new API_requestException("Washer not found, deletion failed");
        }
    }
    //To update a washer
    public WasherDetails updateWasher(WasherDetails washerDetails){
        boolean doesWasherExists=wr.existsById(washerDetails.getId());
        if(doesWasherExists){
            WasherDetails existingWasher = wr.findById(washerDetails.getId()).orElse(null);
            existingWasher.setName(washerDetails.getName());
            existingWasher.setPassword(washerDetails.getPassword());
            return wr.save(existingWasher);
        }
        else {
            throw new API_requestException("Washer not found in database, update failed");
        }
    }

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
}
