package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Account;
import com.lancini.fakeFinancialInstitution.model.Customer;
import com.lancini.fakeFinancialInstitution.model.Transfer;
import com.lancini.fakeFinancialInstitution.repositories.AccountRepository;
import jakarta.ws.rs.core.Response;
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
public class AccountServiceTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountRepository repository;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private CustomerService customerService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)

    private TransferHistoryService transferHistoryService;
    @InjectMocks
    private AccountService service;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAccount() throws Exception {
        Customer customer = new Customer("Clarice", "Lispector");
        Account account = new Account(1L, customer, (long) 99999.99);
        Mockito.when(customerService.getCustomerById(any(Long.class))).thenReturn(Optional.of(customer));
        Mockito.when(repository.save(any(Account.class))).thenReturn(account);
        Account result = this.service.createAccount(1L, (long) 99999.99);
        assertEquals(account, result);
    }

    @Test
    public void testGetAccountBalance() throws Exception {
        Customer customer = new Customer("Clarice", "Lispector");
        Account account = new Account(1L, customer, (long) 99999.99);
        Mockito.when(repository.findById(any(Long.class))).thenReturn(Optional.of(account));
        Long result = this.service.getAccountBalance(1L);
        assertEquals((long) 99999.99, result);
    }

    @Test
    public void testGetTransferHistory() throws Exception {
        Customer customer1 = new Customer("Clarice", "Lispector");
        Customer customer2 = new Customer("Franz", "Kafka");
        Account account1 = new Account(1L, customer1, (long) 99999.99);
        Account account2 = new Account(2L, customer1, (long) 0);
        Account account3 = new Account(3L, customer2, (long) 99999.99);
        Transfer transfer1 = new Transfer(1L, account1, account2, (long) 100);
        Transfer transfer2 = new Transfer(2L, account2, account3, (long) 10);
        List<Transfer> transferList = Arrays.asList(transfer1, transfer2);

        Mockito.when(transferHistoryService.getByAccountId(any(Long.class))).thenReturn(Optional.of(transferList));
        List<Transfer> result = this.service.getTransferHistory(2L);
        assertEquals(2, result.size());
    }

    @Test
    public void testSuccessfulTransferAmount() throws Exception {
        Customer customer1 = new Customer("Clarice", "Lispector");
        Customer customer2 = new Customer("Franz", "Kafka");
        Account account1 = new Account(1L, customer1, (long) 99999.99);
        Account account2 = new Account(2L, customer2, (long) 0);
        Transfer transfer = new Transfer(1L, account1, account2, (long) 100);

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(account1));
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(account2));
        Response.Status result = this.service.transferAmount(transfer);
        assertEquals(Response.Status.OK, result);
        assertEquals((long) 99899.99, account1.getBalance());
        assertEquals((long) 100, account2.getBalance());
    }

    @Test
    public void testFailedTransferAmount() throws Exception {
        Customer customer1 = new Customer("Clarice", "Lispector");
        Customer customer2 = new Customer("Franz", "Kafka");
        Account account1 = new Account(1L, customer1, (long) 99999.99);
        Account account2 = new Account(2L, customer2, (long) 0);
        Transfer transfer = new Transfer(1L, account2, account1, (long) 100);

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(account1));
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(account2));
        Response.Status result = this.service.transferAmount(transfer);
        assertEquals(Response.Status.BAD_REQUEST, result);
        assertEquals((long) 99999.99, account1.getBalance());
        assertEquals((long) 0, account2.getBalance());
    }

}