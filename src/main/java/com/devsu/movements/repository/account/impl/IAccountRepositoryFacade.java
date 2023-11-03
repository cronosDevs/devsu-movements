package com.devsu.movements.repository.account.impl;

import com.devsu.movements.domain.entity.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountRepositoryFacade {

    Account createAccount(Account account);

    Optional<Account> findAccountByAccountNumber(String accountNumber);
    List<Account> findAccountsByCustomerId(Long customerId);
    Optional<Account> findAccountByAccountId(Long accountId);

    Account updateAccount(Account account);
}
