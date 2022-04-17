package edu.miu.cs545.waa.domain;

import edu.miu.cs545.waa.enums.Role;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User extends Base {
    private String name;
    private String email;
    private String declineReason;
    private long rewardPoint;
    private Role role;
}
