package com.devsu.movements.service.report;

import com.devsu.movements.domain.ReportDto;

public interface IReportService {
    ReportDto getReport(String startDate, String endDate, Long customerId);
}
