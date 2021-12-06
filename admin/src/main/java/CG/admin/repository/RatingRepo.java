package CG.admin.repository;

import CG.admin.model.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepo extends MongoRepository<Ratings, String> {

}
