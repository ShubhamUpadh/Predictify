package com.Predictify.www.Controller;


import com.Predictify.www.Model.UserWallet;
import com.Predictify.www.Service.WalletService;
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
    public ResponseEntity<UserWallet> updateBalance(UserWallet userWallet){
        System.out.println("@Controller layer = " + userWallet);
        UserWallet updatedUserWallet = walletService.updateBalance(userWallet);
        return ResponseEntity.ok(updatedUserWallet);
    }

}
