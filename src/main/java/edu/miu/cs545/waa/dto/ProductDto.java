package edu.miu.cs545.waa.dto;

import edu.miu.cs545.waa.domain.dto.Base;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto extends Base {
    private String name;
    private String cost;
    private String description;
    private List<ReviewDto> reviews;
    private List<OrderDto> orders;
}
