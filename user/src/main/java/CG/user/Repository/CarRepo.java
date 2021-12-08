package CG.user.Repository;

import CG.user.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepo extends MongoRepository<Car, Integer> {

}
