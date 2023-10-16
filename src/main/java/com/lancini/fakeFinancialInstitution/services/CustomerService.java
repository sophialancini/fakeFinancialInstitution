package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Customer;
import com.lancini.fakeFinancialInstitution.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> getCustomerById(Long id) {
        return this.repository.findById(id);
    }
}
