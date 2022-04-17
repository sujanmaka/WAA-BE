package edu.miu.cs545.waa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
public class Follow extends Base {

    private Long sellerId;
}
