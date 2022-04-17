package edu.miu.cs545.waa.domain;

import javax.persistence.Entity;

@Entity
public class Follow extends Base {
    private Long followed;
    private Long follower;

}
