package johnny.tutorial.spring.login.controller;

import johnny.tutorial.spring.login.model.Customer;
import johnny.tutorial.spring.login.model.Order;
import johnny.tutorial.spring.login.repository.CustomerRepository;
import johnny.tutorial.spring.login.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@RequestMapping("/customers")
public class CustomerController extends BaseController {
  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository) {
    this.customerRepository = customerRepository;
    this.orderRepository = orderRepository;
  }

  @GetMapping
  public String getAllCustomers(Model model) {
    List<Customer> customers = this.customerRepository.findByOrderByNameAsc();
    model.addAttribute(ATTRIBUTE_KEY_CUSTOMERS, customers);
    model.addAttribute(ATTRIBUTE_KEY_MODULE, MODULE_CUSTOMERS);
    return TEMPLATE_NAME_CUSTOMERS;
  }

  @GetMapping(path = "/{id}")
  public String getCustomer(@PathVariable("id") long customerId, Principal principal, Model model) {
    Optional<Customer> customer = this.customerRepository.findById(customerId);
    if (customer.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, ERROR_ENTITY_NOT_FOUND
      );
    }
    model.addAttribute(ATTRIBUTE_KEY_CUSTOMER, customer.get());
    List<Order> orders = new ArrayList<>();
    if (principal instanceof UsernamePasswordAuthenticationToken) {
      AtomicBoolean auth = new AtomicBoolean(false);
      Collection<GrantedAuthority> authorities = ((UsernamePasswordAuthenticationToken) principal).getAuthorities();
      authorities.forEach(authority -> {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
              auth.set(true);
            }
          }
      );
      if (auth.get()) {
        Iterable<Order> ordersIterable = this.orderRepository.findAllByCustomerId(customer.get().getId());
        ordersIterable.forEach(orders::add);
      }
    }
    model.addAttribute(ATTRIBUTE_KEY_ORDERS, orders);
    model.addAttribute(ATTRIBUTE_KEY_MODULE, MODULE_CUSTOMERS);
    return TEMPLATE_NAME_CUSTOMER_DETAILS;
  }
}
