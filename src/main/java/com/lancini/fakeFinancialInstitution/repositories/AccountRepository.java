package com.lancini.fakeFinancialInstitution.repositories;

import com.lancini.fakeFinancialInstitution.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
