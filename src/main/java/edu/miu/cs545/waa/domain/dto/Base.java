package edu.miu.cs545.waa.domain.dto;

import edu.miu.cs545.waa.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@Data
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant modifiedDate;
    private Status status;
    private String userId;
}
