package com.devsu.movements.util.mapper;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.entity.Account;
import com.devsu.movements.domain.request.AccountRequestDto;
import com.devsu.movements.domain.rsponse.AccountReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountRequestDtoToAccount(AccountRequestDto accountRequestDto);

    AccountDto customerDtoToCustomer(Account account);
    AccountReportResponse accountDtoToAccountReportResponse(AccountDto accountDto);

}
