package CG.admin.repository;

import CG.admin.model.AdminDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<AdminDetails, Integer> {
}
