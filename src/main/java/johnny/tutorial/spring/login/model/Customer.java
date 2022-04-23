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
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "contact_name")
  private String contactName;
  @Column(name = "email")
  private String email;
  @Column(name = "phone_number")
  private String phoneNumber;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Customer{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", contactName='").append(contactName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
