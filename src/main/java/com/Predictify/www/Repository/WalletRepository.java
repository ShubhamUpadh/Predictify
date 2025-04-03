package com.Predictify.www.Repository;

import com.Predictify.www.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    @Query("SELECT w.balance FROM Wallet w WHERE w.id = :walletId")
    Integer findBalanceByWalletId(@Param("walletId") Long walletId);

    boolean existsById(Long walletId)
}
