package com.devsu.movements.service.account;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.entity.Account;
import com.devsu.movements.domain.request.AccountRequestDto;

import java.util.List;

public interface IAccountService {
    AccountDto createAccount(AccountRequestDto accountRequestDto);

    AccountDto findAccountByAccountNumber(String accountNumber);
    List<AccountDto> findAccountsByCustomerId(Long customerId);
    AccountDto updateAccountById(Long accountId, AccountDto accountDto);
}
