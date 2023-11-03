package com.devsu.movements.domain.request;

import com.devsu.movements.domain.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private Long accountId;
    @NotNull(message = "accountNumber can not be null")
    @NotBlank(message = "accountNumber can not be empty")
    private String accountNumber;
    @NotNull(message = "accountType can not be null")
    private AccountTypeEnum accountType;
    private Double balance;
    private Boolean state = true;
    @NotNull(message = "customerId can not be null")
    private Long customerId;
}
