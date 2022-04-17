package edu.miu.cs545.waa.domain;

import edu.miu.cs545.waa.enums.Payment;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "buyer_order")
public class Order extends Base {
    private String orderDate;
    private int quantity;
    @OneToOne
    private Address shippingAddress;
    @OneToOne
    private Address billingAddress;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @ManyToOne
    private Product product;
}
