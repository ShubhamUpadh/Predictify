package com.Predictify.www.Service;

import com.Predictify.www.Model.PlatformTransaction;
import com.Predictify.www.Repository.PlatformTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformTransactionService {
    @Autowired
    PlatformTransactionRepository platformTransactionRepository;
    public PlatformTransaction addPlatformTransaction(PlatformTransaction platformTransaction){
        return platformTransactionRepository.save(platformTransaction);
    }

}
