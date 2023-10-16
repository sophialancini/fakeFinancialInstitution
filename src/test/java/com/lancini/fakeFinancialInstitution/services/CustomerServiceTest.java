package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Customer;
import com.lancini.fakeFinancialInstitution.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private CustomerRepository repository;
    @InjectMocks
    private CustomerService service;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer("Clarice", "Lispector");
        Mockito.when(repository.findById(any(Long.class))).thenReturn(Optional.of(customer));
        Optional<Customer> result = this.service.getCustomerById(1L);
        assertEquals(customer, result.get());
    }

}