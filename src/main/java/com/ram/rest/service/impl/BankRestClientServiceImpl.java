package com.ram.rest.service.impl;

import com.ram.data.User;
import com.ram.rest.service.BankRestClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class BankRestClientServiceImpl implements BankRestClientService {
    @Autowired
    @Qualifier("bankRestTemplate")
    private RestTemplate restTemplate;

    @Value("${bank.service.url}")
    private String bankServiceUrl;

    @Override
    public List<User> getUserData() {
        log.info("Fetching all user data from bank service url {}",bankServiceUrl);
        HttpEntity<List<User>> response = restTemplate
                .exchange(bankServiceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }

    @Override
    public User postUserData(User user) {
        log.info("Posting the user data to bank service url {}",bankServiceUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<>(user,headers);
        HttpEntity<User> response = restTemplate.exchange(bankServiceUrl,HttpMethod.POST,entity,User.class);
        return response.getBody();
    }

    @Override
    public User getUserDataByAccountNumber(Integer accountNumber) {
        log.info("Fetching the user data from bank service url {}",bankServiceUrl);
        HttpEntity<User> response = restTemplate.exchange(bankServiceUrl+"/"+accountNumber,HttpMethod.GET,null,User.class);
        return response.getBody();
    }


}
