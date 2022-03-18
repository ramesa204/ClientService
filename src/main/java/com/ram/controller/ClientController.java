package com.ram.controller;

import com.ram.data.User;
import com.ram.rest.service.BankRestClientService;
import com.ram.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class ClientController {
    @Autowired
    private BankService bankService;

    @GetMapping("/userInfo")
    public List<User> getBankUserInfo(){
        log.info("Started getting the userInfo from BankService");
        return bankService.getUserInfo();
    }
}
