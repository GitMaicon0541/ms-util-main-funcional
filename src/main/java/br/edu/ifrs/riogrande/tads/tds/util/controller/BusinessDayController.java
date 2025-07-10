package br.edu.ifrs.riogrande.tads.tds.util.controller;

import br.edu.ifrs.riogrande.tads.tds.util.dto.BusinessDayRequest;
import br.edu.ifrs.riogrande.tads.tds.util.dto.BusinessDayResponse;
import br.edu.ifrs.riogrande.tads.tds.util.service.BusinessDayCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/date")
public class BusinessDayController {

    private final BusinessDayCalculatorService calculatorService;

    @Autowired
    public BusinessDayController(BusinessDayCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/business-days")
    public ResponseEntity<BusinessDayResponse> calculateBusinessDays(@RequestBody BusinessDayRequest request) {
        LocalDate resultDate = calculatorService.calculateDateAfterBusinessDays(
                request.getStartDate(), request.getBusinessDays());
        
        return ResponseEntity.ok(new BusinessDayResponse(resultDate));
    }
}