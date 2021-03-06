package johnny.tutorial.spring.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
  @GetMapping
  public String getHome(Model model) {
    return TEMPLATE_NAME_INDEX;
  }

  @GetMapping("/login")
  public String getLogin() {
    return TEMPLATE_NAME_LOGIN;
  }
}
