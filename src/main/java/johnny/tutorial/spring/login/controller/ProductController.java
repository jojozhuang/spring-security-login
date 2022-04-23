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
public class ProductController {
  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public String getAllProducts(Model model) {
    List<Product> products = this.productRepository.findByOrderByProductNameAsc();
    model.addAttribute("products", products);
    model.addAttribute("module", "products");
    return "products";
  }

  @GetMapping(path = "/{id}")
  public String getProduct(@PathVariable("id") long customerId, Model model) {
    Optional<Product> product = this.productRepository.findById(customerId);
    if (product.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "entity not found"
      );
    }
    model.addAttribute("product", product.get());
    model.addAttribute("module", "products");
    return "product-details";
  }
}
