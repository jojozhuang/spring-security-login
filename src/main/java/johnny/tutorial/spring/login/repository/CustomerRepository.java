package johnny.tutorial.spring.login.repository;

import johnny.tutorial.spring.login.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
  List<Customer> findByOrderByNameAsc();
}
