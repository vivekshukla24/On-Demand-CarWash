package CG.washer.repository;

import CG.washer.model.WasherDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WasherRepository extends MongoRepository<WasherDetails,Integer> {
}
