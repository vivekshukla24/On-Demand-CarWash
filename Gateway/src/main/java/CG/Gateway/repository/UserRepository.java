package CG.Gateway.repository;

import CG.Gateway.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    //To find a User with its email
    User findByEmail(String email);
}
