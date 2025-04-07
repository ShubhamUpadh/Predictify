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

    public UserBetService(WalletRepository walletRepository, PollRepository pollRepository,
                          PlatformTransactionService platformTransactionService, PlatformWalletRepository platformWalletRepository,
                          UserTransactionService userTransactionService, UserOpinionRepository userOpinionRepository){
        this.walletRepository = walletRepository;
        this.pollRepository = pollRepository;
        this.platformTransactionService = platformTransactionService;
        this.platformWalletRepository = platformWalletRepository;
        this.userTransactionService = userTransactionService;
        this.userOpinionRepository = userOpinionRepository;
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
        return betPlaced(userBetDTO);

    }

    @Transactional
    public ResponseEntity<?> betPlaced(UserBetDTO userBetDTO){
        UserBetResponseDTO userBetResponseDTO = new UserBetResponseDTO();
        //1. create an entry in platform transaction
        PlatformTransaction platformTransaction = new PlatformTransaction(userBetDTO.getPoll_id(), (double) userBetDTO.getAmount(),
                userWalletOperation.BET, 1L);
        platformTransactionService.addPlatformTransaction(platformTransaction);
        userBetResponseDTO.setPollId(userBetDTO.getPoll_id());

        //2. add the amount to platform wallet
        Optional<PlatformWallet> pw = platformWalletRepository.findById(1L);
        if (pw.isPresent()) {
            PlatformWallet pWallet = pw.get();
            Double updatedBalance = pWallet.getBalance() + userBetDTO.getAmount();
            pWallet.setBalance(updatedBalance);
            platformWalletRepository.save(pWallet);
        }
        else throw new RuntimeException("Platform Wallet not found");

        //3. create an entry in user transaction
        UserTransaction userTransaction = new UserTransaction(userBetDTO.getPoll_id(), userBetDTO.getAmount(),
                userWalletOperation.BET, userBetDTO.getId()); // walletID = userID
        userTransactionService.addTransaction(userTransaction);
        userBetResponseDTO.setUserId(userBetDTO.getId());

        //4. create an entry in userOpinion
        UserOpinion userOpinion = new UserOpinion(userBetDTO.getId(), userBetDTO.getPoll_id(), userBetDTO.getOpinion());
        userOpinionRepository.save(userOpinion);
        userBetResponseDTO.setOpinion(userOpinion.getOpinion());

        //5. deduct user balance
        Optional<UserWallet> uW= walletRepository.findById(userBetDTO.getId());
        if (uW.isPresent()) {
            UserWallet userWallet = uW.get();
            int deductedBalance = userWallet.getBalance() - userBetDTO.getAmount();
            userWallet.setBalance(deductedBalance);
            walletRepository.save(userWallet);
            userBetResponseDTO.setBalance(deductedBalance);
        }
        else{
            throw new RuntimeException("User Wallet not found");
        }

        //6.Return the responseEntity

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userBetResponseDTO);
    }

    public boolean hasSufficientBalance(Long walletId, int betAmount){
        Integer balance = walletRepository.findBalanceByWalletId(walletId);
        return balance == null || balance >= betAmount;
    }

    public boolean isPollActive(Long pollId){
        return pollRepository.isPollActive(pollId) || (pollRepository.expiryTime(pollId).isBefore(LocalDateTime.now()));
    }
}
