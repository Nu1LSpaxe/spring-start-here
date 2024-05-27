package com.project.spring_start_here.test.controllers;

import com.project.spring_start_here.test.dto.TestTransferRequest;
import com.project.spring_start_here.test.model.TestAccount;
import com.project.spring_start_here.test.services.TestTransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestAccountController {

    private final TestTransferService testTransferService;

    public TestAccountController(TestTransferService testTransferService) {
        this.testTransferService = testTransferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TestTransferRequest request) {
        testTransferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<TestAccount> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return testTransferService.getAllAccounts();
        } else {
            return testTransferService.findAccountsByName(name);
        }
    }
}
