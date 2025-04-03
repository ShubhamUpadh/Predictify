package com.Predictify.www.Service;


import com.Predictify.www.Model.UserBetDTO;
import com.Predictify.www.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserBetService {
    @Autowired

    WalletRepository walletRepository;
    public UserBetService(){

    }
    public ResponseEntity<?> placeUserBet(UserBetDTO userBetDTO){
        // userId should be correct
        if (!walletRepository.existsById(userBetDTO.getId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message","User not found"));
        }
        //amount should be present
        if (!hasSufficientBalance(userBetDTO.getId(), userBetDTO.getAmount())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message","Poll is inactive"));
        }
        // poll should be active

    }

    public boolean hasSufficientBalance(Long walletId, int betAmount){
        Integer balance = walletRepository.findBalanceByWalletId(walletId);
        return balance == null || balance >= betAmount;
    }
}
