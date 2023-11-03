package com.devsu.movements.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "customer_id")
    private Long customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", updatable = false, insertable = false)
    private Customer customerObject;
}
