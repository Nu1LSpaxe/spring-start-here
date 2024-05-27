package com.project.spring_start_here.test.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.project.spring_start_here.test.model.TestAccount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface TestAccountRepository extends CrudRepository<TestAccount, Long> {

    @Query("SELECT * FROM test_account WHERE name = :name;")
    List<TestAccount> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE test_account SET amount = :amount WHERE id = :id;")
    void changeAmount(long id, BigDecimal amount);
}
