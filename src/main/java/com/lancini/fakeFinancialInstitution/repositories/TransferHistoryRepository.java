package com.lancini.fakeFinancialInstitution.repositories;

import com.lancini.fakeFinancialInstitution.model.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface TransferHistoryRepository extends CrudRepository<Transfer, Long> {

    @Query(value = "SELECT * FROM transferHistory WHERE sender_id = ?1 OR receiver_id = ?1", nativeQuery = true)
    Optional<List<Transfer>> getByAccount(Long accountId);

}
