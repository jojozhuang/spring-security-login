package johnny.tutorial.spring.login.repository;

import johnny.tutorial.spring.login.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  List<Product> findByOrderByIdAsc();
}
