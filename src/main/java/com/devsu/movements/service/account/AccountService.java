package com.devsu.movements.service.account;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.entity.Account;
import com.devsu.movements.domain.request.AccountRequestDto;
import com.devsu.movements.repository.account.impl.IAccountRepositoryFacade;
import com.devsu.movements.util.Utils;
import com.devsu.movements.util.exception.domain.BadRequestException;
import com.devsu.movements.util.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    private final IAccountRepositoryFacade accountRepositoryFacade;

    @Autowired
    public AccountService(IAccountRepositoryFacade accountRepositoryFacade) {
        this.accountRepositoryFacade = accountRepositoryFacade;
    }

    @Override
    public AccountDto createAccount(AccountRequestDto accountRequestDto) {
        Account account = AccountMapper.INSTANCE.accountRequestDtoToAccount(accountRequestDto);
        account.setBalance(0.0);
        return AccountMapper.INSTANCE.customerDtoToCustomer(accountRepositoryFacade.createAccount(account));
    }

    @Override
    public AccountDto findAccountByAccountNumber(String accountNumber) {
        Optional<Account> accountOptional = accountRepositoryFacade.findAccountByAccountNumber(accountNumber);
        return accountOptional.map(AccountMapper.INSTANCE::customerDtoToCustomer)
                .orElseThrow(() -> new BadRequestException("Account " + accountNumber + " not found", null));
    }

    @Override
    public List<AccountDto> findAccountsByCustomerId(Long customerId) {
        List<Account> accountList = accountRepositoryFacade.findAccountsByCustomerId(customerId);
        if (Objects.isNull(accountList) || accountList.isEmpty()) {
            return new ArrayList<>();
        }
        return accountList.stream().map(AccountMapper.INSTANCE::customerDtoToCustomer).toList();
    }

    @Override
    public AccountDto updateAccountById(Long accountId, AccountDto accountDto) {
        Optional<Account> customerOptional = accountRepositoryFacade.findAccountByAccountId(accountId);
        return customerOptional.map(account -> {
            Utils.mergeBeanObjects(account, accountDto);
            Account customerResponse = accountRepositoryFacade.updateAccount(account);
            return AccountMapper.INSTANCE.customerDtoToCustomer(customerResponse);
        }).orElseThrow(() -> new BadRequestException("Account not found", null));
    }
}
