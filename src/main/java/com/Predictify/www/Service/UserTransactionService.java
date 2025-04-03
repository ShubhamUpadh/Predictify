package com.Predictify.www.Service;

import com.Predictify.www.Model.UserTransaction;
import com.Predictify.www.Repository.UserTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransactionService {

    @Autowired
    UserTransactionRepository userTransactionRepository;

    public UserTransaction addTransaction(UserTransaction userTransaction) {
        return userTransactionRepository.save(userTransaction);
    }
}
