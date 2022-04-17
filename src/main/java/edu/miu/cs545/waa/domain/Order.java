package edu.miu.cs545.waa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends Base {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String orderDate;
  private int quantity;
  private String shippingAddress;
  private String billingAddress;
  private String paymentStatus;
}
