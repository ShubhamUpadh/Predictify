package com.Predictify.www.Service;

import com.Predictify.www.Model.Wallet;
import com.Predictify.www.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public Wallet updateBalance(Wallet wallet) {
        System.out.println("@Service layer = " + wallet);
        return walletRepository.save(wallet);
    }
}
