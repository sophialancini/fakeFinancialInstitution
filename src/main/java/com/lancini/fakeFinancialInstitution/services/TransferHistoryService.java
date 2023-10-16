package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Transfer;
import com.lancini.fakeFinancialInstitution.repositories.TransferHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferHistoryService implements TransferHistoryServiceInterface {

    @Autowired
    private TransferHistoryRepository repository;

    @Override
    public Optional<List<Transfer>> getByAccountId(Long accountId) {
        return this.repository.getByAccount(accountId);
    }
}
