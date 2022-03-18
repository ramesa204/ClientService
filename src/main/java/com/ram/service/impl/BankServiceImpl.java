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
        log.info("Making the rest call to bank service api");
        List<User> userList = bankRestClientService.getUserData();
        log.info("{} usersInfo is retrieved",userList.size());
        return userList;
    }
}
