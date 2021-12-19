package CG.zuulsecurity.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import CG.zuulsecurity.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    //To find a role by it's name
    Role findByRole(String role);
}