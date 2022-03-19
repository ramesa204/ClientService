package com.ram.service.impl;

import com.ram.data.User;
import com.ram.rest.service.BankRestClientService;
import com.ram.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRestClientService bankRestClientService;
    @Override
    public List<User> getUserInfo() {
        log.info("Making the rest call to bank service GET api");
        List<User> userList = bankRestClientService.getUserData();
        log.info("{} usersInfo is retrieved",userList.size());
        return userList;
    }

    @Override
    public User createUserInfo(User user) {
        log.info("Making the rest call to bank service POST api");
        User createdUser = bankRestClientService.postUserData(user);
        log.info("{} usersInfo is created in bank service for id {} and name {}",createdUser.getId(),createdUser.getName());
        return createdUser;
    }

    @Override
    public User getUserInfoByAccountNumber(Integer accountNumber) {
        log.info("Making the rest call to bank service GET api");
        User retrievedUser = bankRestClientService.getUserDataByAccountNumber(accountNumber);
        log.info("{} usersInfo is fetched from bank service for id {} and name {}",retrievedUser.getId(),retrievedUser.getName());
        return retrievedUser;
    }
}
