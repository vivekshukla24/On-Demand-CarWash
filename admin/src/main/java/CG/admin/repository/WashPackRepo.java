package CG.admin.repository;

import CG.admin.model.WashPacks;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WashPackRepo extends MongoRepository<WashPacks, String> {
}
