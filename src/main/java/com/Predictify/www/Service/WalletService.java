package com.Predictify.www.Service;

import com.Predictify.www.Model.UserWallet;
import com.Predictify.www.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    public UserWallet updateBalance(UserWallet userWallet) {
        System.out.println("@Service layer = " + userWallet);
        return walletRepository.save(userWallet);
    }
}
