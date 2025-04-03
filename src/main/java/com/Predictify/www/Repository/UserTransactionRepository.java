package com.Predictify.www.Repository;

import com.Predictify.www.Model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, Long> {
}
