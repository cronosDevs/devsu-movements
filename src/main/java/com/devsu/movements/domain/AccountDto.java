package com.devsu.movements.domain;

import com.devsu.movements.domain.entity.Customer;
import com.devsu.movements.domain.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountId;
    private String accountNumber;
    private AccountTypeEnum accountType;
    private Double balance;
    private Boolean state;
    private CustomerDto customerObject;
    private List<MovementDto> movements;
}
