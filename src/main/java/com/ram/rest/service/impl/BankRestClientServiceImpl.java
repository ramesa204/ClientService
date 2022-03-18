package com.ram.rest.service.impl;

import com.ram.data.User;
import com.ram.rest.service.BankRestClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
        log.info("Making the rest call to url {}",bankServiceUrl);
        HttpEntity<List<User>> response = restTemplate
                .exchange(bankServiceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        return response.getBody();
    }
}
