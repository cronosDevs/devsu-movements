package com.devsu.movements.domain;

import com.devsu.movements.domain.rsponse.AccountReportResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private String customerName;
    private List<AccountReportResponse> accounts;
}
