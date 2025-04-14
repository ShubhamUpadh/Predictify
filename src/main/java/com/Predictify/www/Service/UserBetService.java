package com.Predictify.www.Service;


import com.Predictify.www.Enum.userWalletOperation;
import com.Predictify.www.Model.*;
import com.Predictify.www.Repository.PlatformWalletRepository;
import com.Predictify.www.Repository.PollRepository;
import com.Predictify.www.Repository.UserOpinionRepository;
import com.Predictify.www.Repository.WalletRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserBetService {

    WalletRepository walletRepository;
    PollRepository pollRepository;
    PlatformTransactionService platformTransactionService;
    PlatformWalletRepository platformWalletRepository;
    UserTransactionService userTransactionService;
    UserOpinionRepository userOpinionRepository;
    PlaceUserBetService placeUserBetService;

    public UserBetService(WalletRepository walletRepository, PollRepository pollRepository,
                          PlatformTransactionService platformTransactionService, PlatformWalletRepository platformWalletRepository,
                          UserTransactionService userTransactionService, UserOpinionRepository userOpinionRepository,
                          PlaceUserBetService placeUserBetService){
        this.walletRepository = walletRepository;
        this.pollRepository = pollRepository;
        this.platformTransactionService = platformTransactionService;
        this.platformWalletRepository = platformWalletRepository;
        this.userTransactionService = userTransactionService;
        this.userOpinionRepository = userOpinionRepository;
        this.placeUserBetService = placeUserBetService;
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
                    .body(Collections.singletonMap("message","Balance insufficient "));
        }
        // poll should be active
        if (!isPollActive(userBetDTO.getPoll_id())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", "InactivePoll"));
        }
        // if we have reached here, then balance is present and poll is active
        //now everything has to be transactional
        //1. create an entry in platform transaction
        //2. add the amount to platform wallet
        //3. create an entry in user transaction
        //4. create an entry in userOpinion
        //5. deduct user balance
        return placeUserBetService.betPlaced(userBetDTO);

    }


    public boolean hasSufficientBalance(Long walletId, int betAmount){
        Integer balance = walletRepository.findBalanceByWalletId(walletId);
        return balance != null || balance >= betAmount;
    }

    public boolean isPollActive(Long pollId){
        return pollRepository.isPollActive(pollId) || (pollRepository.expiryTime(pollId).isAfter(LocalDateTime.now()));
    }
}
