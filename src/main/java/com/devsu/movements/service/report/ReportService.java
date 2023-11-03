package com.devsu.movements.service.report;

import com.devsu.movements.domain.AccountDto;
import com.devsu.movements.domain.ReportDto;
import com.devsu.movements.domain.rsponse.AccountReportResponse;
import com.devsu.movements.service.account.IAccountService;
import com.devsu.movements.service.movement.IMovementService;
import com.devsu.movements.util.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReportService implements IReportService {

    private final IAccountService accountService;
    private final IMovementService movementService;

    @Autowired
    public ReportService(IAccountService accountService, IMovementService movementService) {
        this.accountService = accountService;
        this.movementService = movementService;
    }

    @Override
    public ReportDto getReport(String startDate, String endDate, Long customerId) {
        List<AccountDto> accountDtoList = accountService.findAccountsByCustomerId(customerId);
        if (Objects.isNull(accountDtoList) || accountDtoList.isEmpty()) {
            return null;
        }
        ReportDto reportDto = new ReportDto();
        reportDto.setCustomerName(accountDtoList.get(0).getCustomerObject().getPerson().getName());

        List<AccountReportResponse> accountReportResponseList = accountDtoList.stream().map(AccountMapper.INSTANCE::accountDtoToAccountReportResponse).toList();
        accountReportResponseList.forEach(accountReportResponse -> {
            accountReportResponse.setMovements(movementService.findMovementsByDates(startDate, endDate, accountReportResponse.getAccountId()));
        });
        reportDto.setAccounts(accountReportResponseList);
        return reportDto;
    }
}
