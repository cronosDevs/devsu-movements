package com.devsu.movements.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id")
    private Long movementId;
    @Column(name = "date")
    private Date date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "type")
    private String type;
    @Column(name = "account_id")
    private Long accountId;
}
