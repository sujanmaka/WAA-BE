package edu.miu.cs545.waa.domain;

import edu.miu.cs545.waa.domain.dto.Base;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Product extends Base {

    private String name;
    private String cost;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;
}
