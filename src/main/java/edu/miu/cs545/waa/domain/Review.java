package edu.miu.cs545.waa.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Review extends Base{
    private String title;
    private String content;

    @ManyToOne
    private Product product;
}
