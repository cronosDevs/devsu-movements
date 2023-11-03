package com.devsu.movements.service.movement;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.MovementDto;
import com.devsu.movements.domain.entity.Movement;
import com.devsu.movements.domain.enums.MovementTypeEnum;
import com.devsu.movements.domain.request.MovementRequestDto;
import com.devsu.movements.repository.movement.impl.IMovementRepositoryFacade;
import com.devsu.movements.service.account.IAccountService;
import com.devsu.movements.util.exception.domain.BadRequestException;
import com.devsu.movements.util.mapper.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

@Service
public class MovementService implements IMovementService {

    private final IMovementRepositoryFacade movementRepositoryFacade;

    private final IAccountService accountService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Autowired
    public MovementService(IMovementRepositoryFacade movementRepositoryFacade, IAccountService accountService) {
        this.movementRepositoryFacade = movementRepositoryFacade;
        this.accountService = accountService;
    }

    @Override
    @Transactional
    public MovementDto createMovement(MovementRequestDto movementRequestDto) {
        AccountDto account = accountService.findAccountByAccountNumber(movementRequestDto.account);
        MovementTypeEnum movementTypeEnum;
        if (Objects.isNull(account.getBalance())) {
            account.setBalance(0.0);
        }
        if (movementRequestDto.getAmount() > 0) {
            account.setBalance(account.getBalance() + movementRequestDto.getAmount());
            movementTypeEnum = MovementTypeEnum.deposit;
        } else {
            if (account.getBalance() < (movementRequestDto.getAmount() * -1)) {
                throw new BadRequestException("unavailable balance", null);
            }
            account.setBalance(account.getBalance() + movementRequestDto.getAmount());
            movementTypeEnum = MovementTypeEnum.withdrawal;
        }
        accountService.updateAccountById(account.getAccountId(), account);

        MovementDto movementDto = MovementDto.builder()
                .date(new Date())
                .type(movementTypeEnum)
                .amount(movementRequestDto.amount)
                .accountId(account.getAccountId())
                .build();


        return MovementMapper.INSTANCE.movementToMovementDto(
                movementRepositoryFacade.createMovement(
                        MovementMapper.INSTANCE.movementDtoToMovement(movementDto)));
    }

    @Override
    public List<MovementDto> findMovementsByDates(String initDateString, String finishDateString, Long accountId) {
        LocalDate localStartDate = LocalDate.parse(initDateString, formatter);
        Date initDate = java.sql.Date.valueOf(localStartDate);

        LocalDate localFinishDate = LocalDate.parse(finishDateString, formatter);
        Date finishDate = java.sql.Date.valueOf(localFinishDate);

        List<Movement> movementList = movementRepositoryFacade.findMovementsBetweenDates(initDate, finishDate, accountId);
        if(Objects.isNull(movementList) || movementList.isEmpty()){
            return new ArrayList<>();
        }

        return movementList.stream().map(MovementMapper.INSTANCE::movementToMovementDto).toList();
    }
}
