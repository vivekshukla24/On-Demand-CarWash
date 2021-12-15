package CG.Gateway.repository;

import CG.Gateway.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Integer> {
    //To find a role
    Role findByRole(String role);
}
