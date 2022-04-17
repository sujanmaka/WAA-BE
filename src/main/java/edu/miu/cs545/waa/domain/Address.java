package edu.miu.cs545.waa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String state;
}