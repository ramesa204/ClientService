package com.ram.rest.service;

import com.ram.data.User;

import java.util.List;

public interface BankRestClientService {
    List<User> getUserData();
    User postUserData(User user);
    User getUserDataByAccountNumber(Integer accountNumber);
}
