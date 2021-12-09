package CG.admin.service;

import CG.admin.model.AdminDetails;
import CG.admin.model.OrderDetails;
import CG.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    String url="http://localhost:8082/orders";

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
        ar.deleteById(id);
        return "Admin with ID"+id+"deleted successfully";
    }
    //To update an admin
    public AdminDetails updateAdmin(AdminDetails adminDetails){
        AdminDetails existingAdmin= ar.findById(adminDetails.getId()).orElse(null);
        existingAdmin.setName(adminDetails.getName());
        existingAdmin.setPassword(adminDetails.getPassword());
        return ar.save(existingAdmin);
    }
    //To update the status of the order
    public OrderDetails updateStatus(OrderDetails orderDetails){
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails);
        return restTemplate.exchange(url+"/updateStatus", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
    }
}
