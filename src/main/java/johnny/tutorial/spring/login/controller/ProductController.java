package johnny.tutorial.spring.login.controller;

import johnny.tutorial.spring.login.model.Product;
import johnny.tutorial.spring.login.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {
  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public String getAllProducts(Model model) {
    List<Product> products = this.productRepository.findByOrderByIdAsc();
    model.addAttribute(ATTRIBUTE_KEY_PRODUCTS, products);
    model.addAttribute(ATTRIBUTE_KEY_MODULE, MODULE_PRODUCTS);
    return TEMPLATE_NAME_PRODUCTS;
  }

  @GetMapping(path = "/{id}")
  public String getProduct(@PathVariable("id") long customerId, Model model) {
    Optional<Product> product = this.productRepository.findById(customerId);
    if (product.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, ERROR_ENTITY_NOT_FOUND
      );
    }
    model.addAttribute(ATTRIBUTE_KEY_PRODUCT, product.get());
    model.addAttribute(ATTRIBUTE_KEY_MODULE, MODULE_PRODUCTS);
    return TEMPLATE_NAME_PRODUCT_DETAILS;
  }
}
