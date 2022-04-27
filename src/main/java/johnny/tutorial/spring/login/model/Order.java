package johnny.tutorial.spring.login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "order_id")
  private long id;
  @Column(name = "customer_id")
  private long customerId;
  @Column(name = "items")
  private String items;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Order{");
    sb.append("id=").append(id);
    sb.append(", customerId=").append(customerId);
    sb.append(", items='").append(items).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
