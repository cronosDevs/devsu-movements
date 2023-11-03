package com.devsu.movements.controller;

import com.devsu.movements.domain.ReportDto;
import com.devsu.movements.service.report.IReportService;
import com.devsu.movements.util.endpoint.ReportEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ReportEndpoint.BASE_PATH)
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
public class ReportController {

    private final IReportService reportService;

    @Autowired
    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(ReportEndpoint.REPORTS)
    public ResponseEntity<ReportDto>
    getReport(@RequestParam(value = "startDate") String startDate,
              @RequestParam(value = "endDate") String endDate,
              @RequestParam(value = "customerId") Long customerId) {
        ReportDto report = reportService.getReport(startDate, endDate, customerId);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}
