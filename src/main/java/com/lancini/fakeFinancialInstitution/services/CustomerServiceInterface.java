package com.lancini.fakeFinancialInstitution.services;

import com.lancini.fakeFinancialInstitution.model.Customer;

import java.util.Optional;

public interface CustomerServiceInterface {

    Optional<Customer> getCustomerById(Long id);

}
