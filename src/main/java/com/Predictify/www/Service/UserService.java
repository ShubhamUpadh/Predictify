package com.Predictify.www.Service;

import com.Predictify.www.Model.User;
import com.Predictify.www.Model.UserWallet;
import com.Predictify.www.Repository.UserRepository;
import com.Predictify.www.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? Collections.emptyList() : users;
    }

    @Transactional
    public User addUser(User user) {
        User savedUser = userRepository.save(user);

        UserWallet userWallet = new UserWallet(savedUser.getId(), 0);
        walletRepository.saveAndFlush(userWallet);
        return savedUser;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public List<User> addUsers(List<User> users) {
        List<User> savedUsers = new ArrayList<>();
        for (User user : users) {
            savedUsers.add(userRepository.save(user));
        }

        for (User savedUser : savedUsers){
            UserWallet userWallet = new UserWallet(savedUser.getId(), 0);
            walletRepository.save(userWallet);
        }
        return  savedUsers;
    }
}
