package johnny.tutorial.spring.login.repository;

import static org.assertj.core.api.Assertions.assertThat;
import johnny.tutorial.spring.login.model.Customer;
import johnny.tutorial.spring.login.model.Order;
import johnny.tutorial.spring.login.model.Product;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void testGetAllProducts() {
    Iterable<Product> products = productRepository.findAll();
    assertThat(IterableUtils.size(products)).isEqualTo(5);
  }

  @Test
  public void testGetAllCustomers() {
    Iterable<Customer> customers = customerRepository.findAll();
    assertThat(IterableUtils.size(customers)).isEqualTo(7);
  }

  @Test
  public void testGetAllOrders() {
    Iterable<Order> orders = orderRepository.findAll();
    assertThat(IterableUtils.size(orders)).isEqualTo(5);
  }
}
