package com.devsu.movements.domain.rsponse;

import com.devsu.movements.domain.MovementDto;
import com.devsu.movements.domain.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountReportResponse {
    private Long accountId;
    private String accountNumber;
    private AccountTypeEnum accountType;
    private Double balance;
    private Boolean state;
    private List<MovementDto> movements = new ArrayList<>();
}
