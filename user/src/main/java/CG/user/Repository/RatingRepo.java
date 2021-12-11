package CG.user.Repository;

import CG.user.model.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepo extends MongoRepository<Ratings, Integer> {

}
