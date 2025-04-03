package com.Predictify.www.Controller;


import com.Predictify.www.Model.UserTransaction;
import com.Predictify.www.Service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserTransactionController {

    @Autowired
    UserTransactionService userTransactionService;

    @PostMapping("/addTransaction")
    public UserTransaction addTransaction(UserTransaction userTransaction){
        return userTransactionService.addTransaction(userTransaction);
    }
//
//    @GetMapping
//    public  List<UserTransaction> getAllTransactionsById()
}
