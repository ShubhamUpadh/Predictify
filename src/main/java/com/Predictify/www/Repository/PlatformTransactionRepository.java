package com.Predictify.www.Repository;

import com.Predictify.www.Model.PlatformTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformTransactionRepository extends JpaRepository<PlatformTransaction, Long> {
}
