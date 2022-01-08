package CG.order.repository;

import CG.order.model.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<OrderDetails, String> {

}
