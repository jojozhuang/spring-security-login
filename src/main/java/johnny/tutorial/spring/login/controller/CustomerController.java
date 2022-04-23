package johnny.tutorial.spring.login.controller;

import johnny.tutorial.spring.login.model.Customer;
import johnny.tutorial.spring.login.model.Order;
import johnny.tutorial.spring.login.repository.CustomerRepository;
import johnny.tutorial.spring.login.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository) {
    this.customerRepository = customerRepository;
    this.orderRepository = orderRepository;
  }

  @GetMapping
  public String getAllCustomers(Model model) {
    List<Customer> customers = this.customerRepository.findByOrderByNameAsc();
    model.addAttribute("customers", customers);
    model.addAttribute("module", "customers");
    return "customers";
  }

  @GetMapping(path = "/{id}")
  public String getCustomer(@PathVariable("id") long customerId, Model model) {
    Optional<Customer> customer = this.customerRepository.findById(customerId);
    if (customer.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "entity not found"
      );
    }
    model.addAttribute("customer", customer.get());
    Iterable<Order> ordersIterable = this.orderRepository.findAllByCustomerId(customer.get().getId());
    List<Order> orders = new ArrayList<>();
    ordersIterable.forEach(orders::add);
    model.addAttribute("orders", orders);
    model.addAttribute("module", "customers");
    return "customer-details";
  }
}
