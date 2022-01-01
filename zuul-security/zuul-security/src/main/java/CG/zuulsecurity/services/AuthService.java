package CG.zuulsecurity.services;

import CG.zuulsecurity.models.Role;
import CG.zuulsecurity.models.User;
import CG.zuulsecurity.repositories.RoleRepository;
import CG.zuulsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    private UserRepository ur;
    @Autowired
    private RoleRepository roleRepository;

    //To get all the users from DB
    public List<User> getAllUser(){
        return ur.findAll();
    }
    //This method will be consumed by 3-entity microservices using rest template
    //To find a user of any role using name
    public User getSpecificUser(String name){
        return ur.findAll().stream().filter(x -> x.getFullname().contains(name)).findFirst().get();
    }
    //To delete a User
    public String deleteUser(String id){
        boolean doesAdminExists=ur.existsById(id);
        if(doesAdminExists) {
            ur.deleteById(id);
            return "Admin with ID " + id + " deleted successfully";
        }
        else {
            return "User with ID "+ id +" not found deletion failed";
        }
    }
    //To fnd user with their role
    public List<User> findListbyRole(String role) {
        Role r=roleRepository.findByRole(role);
        //System.out.println(r);
        Set<Role> roles= new HashSet<>();
        roles.add(r);
        return ur.findByRolesIn(roles);
    }
    public User getWasher(String name){
        Role r=roleRepository.findByRole("WASHER");
        //System.out.println(r);
        Set<Role> roles= new HashSet<>();
        roles.add(r);
        return ur.findByRolesIn(roles).stream().filter(x -> x.getFullname().contains(name)).findFirst().get();
    }
}
