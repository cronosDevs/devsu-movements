package com.devsu.movements.controller;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.request.AccountRequestDto;
import com.devsu.movements.service.account.IAccountService;
import com.devsu.movements.util.endpoint.AccountEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = AccountEndpoint.BASE_PATH)
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.OPTIONS
        })
public class AccountController {

    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(AccountEndpoint.ACCOUNTS)
    public ResponseEntity<AccountDto>
    createAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) throws IllegalAccessException {
        AccountDto response = accountService.createAccount(accountRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
