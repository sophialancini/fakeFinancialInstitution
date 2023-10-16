package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Account;
import com.lancini.fakeFinancialInstitution.model.Transfer;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface AccountServiceInterface {

    Account createAccount(Long customerId, Long initialDeposit) throws Exception;

    Long getAccountBalance(Long accountId) throws Exception;

    List<Transfer> getTransferHistory(Long accountId) throws Exception;

    Response.Status transferAmount(Transfer transfer) throws Exception;
}
