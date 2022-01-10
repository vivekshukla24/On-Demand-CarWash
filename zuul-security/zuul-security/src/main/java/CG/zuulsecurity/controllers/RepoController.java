package CG.zuulsecurity.controllers;

import CG.zuulsecurity.models.User;
import CG.zuulsecurity.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable String id){
        return as.deleteUser(id);
    }
    @GetMapping("/users/{role}")
    public List<User> getUserByRole(@PathVariable String role){
        return as.findListbyRole(role);
    }
    @GetMapping("/washer/{name}")
    public User getWasher(@PathVariable String name){
        return as.getWasher(name);
    }
}
