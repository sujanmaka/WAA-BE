package edu.miu.cs545.waa.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Address extends Base {
    private String street;
    private String city;
    private String zipCode;
    private String state;
}
