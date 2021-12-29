package CG.zuulsecurity.controllers;

import CG.zuulsecurity.models.User;
import CG.zuulsecurity.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class RepoController {
    @Autowired
    private AuthService as;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return as.getAllUser();
    }
    @GetMapping("/userByName/{name}")
    public User getSpecificUser(@PathVariable String name){
        return as.getSpecificUser(name);
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        return as.deleteUser(id);
    }
    @GetMapping("/users/{role}")
    public List<User> getUserByRole(@PathVariable String role){
        return as.findListbyRole(role);
    }

}
