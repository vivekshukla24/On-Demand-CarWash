package CG.zuulsecurity.services;

import CG.zuulsecurity.models.User;
import CG.zuulsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AuthService {
    @Autowired
    private UserRepository ur;

    //To get all the users from DB
    public List<User> getAllUser(){
        return ur.findAll();
    }
    //To get all Admins
    public List<User> getAllAdmins(){
        return ur.findAll().stream().filter(x -> x.getRoles().contains("61ba26a735c79a10aca1ded0")).collect(Collectors.toList());
    }
    //To get all Users
    public List<User> getAllUsers(){
        return ur.findAll().stream().filter(x -> x.getRoles().contains("61baf82f7b90032c48127fac")).collect(Collectors.toList());
    }
    //To get all Washers
    public List<User> getAllWashers(){
        return ur.findAll().stream().filter(x -> x.getRoles().contains("61baf84c7b90032c48127fae")).collect(Collectors.toList());
    }

}
