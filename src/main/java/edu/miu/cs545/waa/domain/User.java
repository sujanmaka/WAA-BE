package edu.miu.cs545.waa.domain;

import enums.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class User extends Base {
    private String name;
    private String email;
    private String declineReason;
    private String pointCollected;
    private Role roleType;

    @ManyToMany(mappedBy = "users")
    private List<Product> products;
}
