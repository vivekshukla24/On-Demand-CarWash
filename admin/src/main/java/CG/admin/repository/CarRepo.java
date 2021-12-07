package CG.admin.repository;

import CG.admin.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepo extends MongoRepository<Car, Integer> {

}
