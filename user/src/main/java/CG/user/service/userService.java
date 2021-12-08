package CG.user.service;

import CG.user.Repository.UserRepository;
import CG.user.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class userService {
    @Autowired
    private UserRepository ur;

    //To get all the users
    public List<UserDetails> findallUsers(){
        return ur.findAll();
    }
    //To find a user by id
    public UserDetails findoneUser(int id){
        return ur.findById(id).get();
    }
    //To add a user
    public UserDetails addUser(UserDetails userDetails) {
        return ur.save(userDetails);
    }
    //To delete a user
    public String deleteUser(int id){
        ur.deleteById(id);
        return "User Deleted Successfully";
    }
    //To update a user
    public UserDetails updateuser(UserDetails userDetails){
        UserDetails existingUser= ur.findById(userDetails.getId()).orElse(null);
        existingUser.setName(userDetails.getName());
        existingUser.setLocation(userDetails.getLocation());
        existingUser.setPassword(userDetails.getPassword());
        return ur.save(existingUser);
    }

}
