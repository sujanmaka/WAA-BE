package edu.miu.cs545.waa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.miu.cs545.waa.domain.Address;
import edu.miu.cs545.waa.domain.dto.Base;
import edu.miu.cs545.waa.enums.Payment;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto extends Base {
    private String orderDate;
    private int quantity;
    private Address shippingAddress;
    private Address billingAddress;
    private Payment payment;
    private Long productId;
}
