package com.devsu.movements.repository.account.impl;

import com.devsu.movements.domain.entity.Account;
import com.devsu.movements.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountRepository implements IAccountRepositoryFacade {

    private final IAccountRepository accountRepository;

    @Autowired
    public AccountRepository(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumberAndState(accountNumber, true);
    }

    @Override
    public List<Account> findAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerIdAndState(customerId, true);
    }

    @Override
    public Optional<Account> findAccountByAccountId(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
