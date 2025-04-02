package com.Predictify.www.Controller;


import com.Predictify.www.Service.WalletService;
import com.Predictify.www.Model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;

    @PutMapping("/add-balance/{id}")
    public ResponseEntity<Wallet> updateBalance(Wallet wallet){
        System.out.println("@Controller layer = " + wallet);
        Wallet updatedWallet = walletService.updateBalance(wallet);
        return ResponseEntity.ok(updatedWallet);
    }

}
