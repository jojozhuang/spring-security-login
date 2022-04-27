package johnny.tutorial.spring.login.repository;

import johnny.tutorial.spring.login.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> findAllByCustomerId(long customerId);
}
