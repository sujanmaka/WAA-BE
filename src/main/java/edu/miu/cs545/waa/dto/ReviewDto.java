package edu.miu.cs545.waa.dto;

import edu.miu.cs545.waa.domain.Product;
import lombok.Data;

@Data
public class ReviewDto {
    private String title;
    private String content;
    private Product product;
}
