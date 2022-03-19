package com.ram.service;

import com.ram.data.User;

import java.util.List;

public interface BankService {
    List<User>  getUserInfo();
    User createUserInfo(User user);
    User getUserInfoByAccountNumber(Integer accountNumber);
}
