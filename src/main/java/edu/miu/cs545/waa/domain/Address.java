package edu.miu.cs545.waa.domain;

import edu.miu.cs545.waa.domain.dto.Base;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Address extends Base {
    private String street;
    private String city;
    private String zipCode;
    private String state;
}
