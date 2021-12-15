package CG.user.Repository;

import CG.user.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDetails, Integer> {

}
