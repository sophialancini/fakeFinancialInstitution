package com.lancini.fakeFinancialInstitution.controllers;

import com.lancini.fakeFinancialInstitution.model.Transfer;
import com.lancini.fakeFinancialInstitution.services.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Api(value = "Fake Financial Institution API")
public class AccountRestController {

    @Autowired
    private AccountService service;

    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Long customerId, Long initialDeposit) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.createAccount(customerId, initialDeposit));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Customer Id not found");
        }
    }

    @PutMapping("/transfer")
    public ResponseEntity transferAmount(@RequestBody Transfer transfer) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.transferAmount(transfer));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Account not found");
        }
    }

    @GetMapping("/get-balance")
    public ResponseEntity getAccountBalance(@RequestBody Long accountId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.getAccountBalance(accountId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Account not found");
        }
    }

    @GetMapping("/get-transfer-history")
    public ResponseEntity getTransferHistory(@RequestBody Long accountId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.getTransferHistory(accountId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Account not found");
        }
    }

}
