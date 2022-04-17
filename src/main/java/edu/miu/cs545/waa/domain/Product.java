package edu.miu.cs545.waa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Product extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cost;
    private String description;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviews;

    @ManyToMany
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Order> orders;
}
