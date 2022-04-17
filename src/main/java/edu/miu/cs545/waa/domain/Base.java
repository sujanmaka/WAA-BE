package edu.miu.cs545.waa.domain;

import enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
public class Base {
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant modifiedDate;
    private Status status;
}
