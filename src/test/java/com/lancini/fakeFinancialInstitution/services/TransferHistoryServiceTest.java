package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Account;
import com.lancini.fakeFinancialInstitution.model.Customer;
import com.lancini.fakeFinancialInstitution.model.Transfer;
import com.lancini.fakeFinancialInstitution.repositories.TransferHistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class TransferHistoryServiceTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private TransferHistoryRepository repository;
    @InjectMocks
    private TransferHistoryService service;
    private  Customer customer1, customer2;
    private Account account1, account2, account3;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customer1 = new Customer("Clarice", "Lispector");
        customer2 = new Customer("Franz", "Kafka");
        account1 = new Account(1L, customer1, (long) 99999.99);
        account2 = new Account(2L, customer1, (long) 0);
        account3 = new Account(3L, customer2, (long) 99999.99);
    }

    @Test
    public void testGetByAccount() throws Exception {
        Transfer transfer1 = new Transfer(1L, account1, account2, (long) 100);
        Transfer transfer2 = new Transfer(2L, account2, account3, (long) 10);
        List<Transfer> transferList = Arrays.asList(transfer1, transfer2);
        Mockito.when(repository.getByAccount(any(Long.class))).thenReturn(Optional.of(transferList));
        Optional<List<Transfer>> result = this.service.getByAccountId((long) 2);
        assertEquals(2, result.get().size());
    }

}