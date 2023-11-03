package com.devsu.movements.repository.account;

import com.devsu.movements.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumberAndState(String accountNumber, Boolean state);
    List<Account> findByCustomerIdAndState(Long accountNumber, Boolean state);


}
