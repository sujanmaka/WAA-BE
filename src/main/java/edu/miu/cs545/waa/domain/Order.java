package edu.miu.cs545.waa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Order extends Base {
    private String orderDate;
    private int quantity;
    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billingAddress;
    private String paymentStatus;
}
