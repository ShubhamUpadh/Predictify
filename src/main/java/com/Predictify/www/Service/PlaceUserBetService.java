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

import java.util.Optional;

@Service
public class PlaceUserBetService {
    WalletRepository walletRepository;
    PollRepository pollRepository;
    PlatformTransactionService platformTransactionService;
    PlatformWalletRepository platformWalletRepository;
    UserTransactionService userTransactionService;
    UserOpinionRepository userOpinionRepository;

    public PlaceUserBetService(WalletRepository walletRepository, PollRepository pollRepository,
                          PlatformTransactionService platformTransactionService, PlatformWalletRepository platformWalletRepository,
                          UserTransactionService userTransactionService, UserOpinionRepository userOpinionRepository){
        this.walletRepository = walletRepository;
        this.pollRepository = pollRepository;
        this.platformTransactionService = platformTransactionService;
        this.platformWalletRepository = platformWalletRepository;
        this.userTransactionService = userTransactionService;
        this.userOpinionRepository = userOpinionRepository;
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

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userBetResponseDTO);
    }
}
