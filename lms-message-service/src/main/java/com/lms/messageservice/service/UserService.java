package com.lms.messageservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final WebClient webClient;

    /**
     * getting list of all users from LMS application by using web Client
     * @return List of User emails
     */


    public List<String> getUserLoginList() {
        List<String> userLoginDto = webClient.get()
                .uri("http://localhost:1234/lms/fetch-emails")
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
        log.info("in Lms application");
        if (userLoginDto != null && !userLoginDto.isEmpty()) {
            log.info("userLoginDto : {}", userLoginDto);
        }
        else {
            throw new IllegalArgumentException("Users emails are not available, please try again");
        }
        return userLoginDto;
    }
}

