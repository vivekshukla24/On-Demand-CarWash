package CG.user.controller;

import CG.user.Repository.UserRepository;
import CG.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableEurekaClient
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository ur;

    //To get all the users
    @GetMapping("/findall")
    public List<UserDetails> findallUsers(){
        return ur.findAll();
    }
    //To find a user by id
    @GetMapping("/findone/{id}")
    public UserDetails findoneUser(@PathVariable int id){
        return ur.findById(id).get();
    }
    //To add a user
    @PostMapping("/add")
    public UserDetails addUser(@RequestBody UserDetails userDetails) {
        return ur.save(userDetails);
    }
    //To delete a user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        ur.deleteById(id);
        return "User Deleted Successfully";
    }
    //To update a user
    @PutMapping
    public UserDetails updateuser(@RequestBody UserDetails userDetails){
        UserDetails existingUser= ur.findById(userDetails.getId()).orElse(null);
        existingUser.setName(userDetails.getName());
        existingUser.setLocation(userDetails.getLocation());
        existingUser.setPassword(userDetails.getPassword());
        return existingUser;
    }
}
