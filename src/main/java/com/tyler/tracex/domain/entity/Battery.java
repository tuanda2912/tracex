package com.tyler.tracex.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="BATTERY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Battery {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="ID", columnDefinition = "CHAR(128) NOT NULL")
    private String id;
    @Column(name="NAME")
    private String name;
    @Column(name="POST_CODE")
    private Integer postCode;
    @Column(name="WATT_CAPACITY")
    private Double wattCapacity;
    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name="UPDATE_TIME")
    private LocalDateTime updateTime;
}
