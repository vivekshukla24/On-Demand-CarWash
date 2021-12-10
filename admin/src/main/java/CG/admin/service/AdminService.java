package CG.admin.service;

import CG.admin.exceptionHandlers.API_requestException;
import CG.admin.model.AdminDetails;
import CG.admin.model.OrderDetails;
import CG.admin.repository.AdminRepo;
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
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    //Provided with the Port of Gateway API
    String url="http://localhost:9000/orders";

    @Autowired
    private AdminRepo ar;

    //To get all admins
    public List<AdminDetails> findallAdmins(){
        return ar.findAll();
    }
    //To find one admin
    public AdminDetails findoneAdmin(int id){
        return ar.findById(id).get();
    }
    //To add an admin
    public AdminDetails addAdmin(AdminDetails adminDetails){
        return ar.save(adminDetails);
    }
    //To delete an admin
    public String deleteAdmin(int id){
        boolean doesAdminExists=ar.existsById(id);
        if(doesAdminExists) {
            ar.deleteById(id);
            return "Admin with ID " + id + " deleted successfully";
        }
        else {
            throw new API_requestException("Admin not found, deletion failed");
        }
    }
    //To update an admin
    public AdminDetails updateAdmin(AdminDetails adminDetails){
        AdminDetails existingAdmin= ar.findById(adminDetails.getId()).orElse(null);
        existingAdmin.setName(adminDetails.getName());
        existingAdmin.setPassword(adminDetails.getPassword());
        return ar.save(existingAdmin);
    }

    /** Only the methods that return to rest templates are below this comment**/

    //To update the status of the order
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        OrderDetails od = restTemplate.exchange(url+"/updateStatus", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
        return od;
    }
    //To get all the orders
    public List<OrderDetails> getallOrders(){
        OrderDetails[] od= restTemplate.getForObject(url+"/findall", OrderDetails[].class);
        return Arrays.asList(od);
    }
}
