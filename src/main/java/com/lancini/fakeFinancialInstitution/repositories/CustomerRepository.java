package com.lancini.fakeFinancialInstitution.repositories;

import com.lancini.fakeFinancialInstitution.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
