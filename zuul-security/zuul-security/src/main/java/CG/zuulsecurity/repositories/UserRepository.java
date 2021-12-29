package CG.zuulsecurity.repositories;

import CG.zuulsecurity.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import CG.zuulsecurity.models.User;

import java.util.List;
import java.util.Set;

public interface UserRepository extends MongoRepository<User, String> {
    //To find a User with his/her email
    User findByEmail(String email);
    //To find user using his/her role
    List<User> findByRolesIn(Set<Role> roles);

}