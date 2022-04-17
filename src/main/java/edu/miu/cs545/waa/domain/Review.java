package edu.miu.cs545.waa.domain;

import javax.persistence.Entity;

@Entity
public class Review extends Base{
    private String title;
    private String content;
}
