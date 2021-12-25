package CG.zuulsecurity.services;

import CG.zuulsecurity.models.User;
import CG.zuulsecurity.refModel.UserDetails;
import CG.zuulsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository ur;
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of User Service
    String url1="http://ADMIN-SERVICE/admins";
    //Url to access the methods of User Service
    String url2="http://USER-SERVICE/users";
    //Url to access the methods of Washer Service
    String url3="http://WASHER-SERVICE/washers";

    //To get all the users from DB
    public List<User> getAllUser(){
        return ur.findAll();
    }
    //This method will be consumed by 3-entity microservices using rest template
    //To find a user of any role using name
    public User getSpecificUser(String name){
        return ur.findAll().stream().filter(x -> x.getFullname().contains(name)).findFirst().get();
    }
    public String deleteUser(String id){
        boolean doesAdminExists=ur.existsById(id);
        if(doesAdminExists) {
            ur.deleteById(id);
            return "Admin with ID " + id + " deleted successfully";
        }
        else {
            return "User with ID "+ id +" Not found deletion failed";
        }
    }
    public UserDetails saveInUR(UserDetails ud){
        HttpEntity<UserDetails> addUser = new HttpEntity<>(ud);
        UserDetails saved=restTemplate.postForObject(url2+"/adduser",addUser,UserDetails.class);
        return saved;
    }
}
