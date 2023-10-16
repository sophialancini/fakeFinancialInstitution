package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferHistoryServiceInterface {
    Optional<List<Transfer>> getByAccountId(Long accountId) throws Exception;
}
