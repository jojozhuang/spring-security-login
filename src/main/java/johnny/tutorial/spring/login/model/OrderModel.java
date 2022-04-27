package johnny.tutorial.spring.login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderModel {
  private long orderId;
  private String customer;
  private long customerId;
  private String orderDetails;
}
