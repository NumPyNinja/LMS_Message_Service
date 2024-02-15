package com.lms.messageservice.controller;

import com.lms.messageservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fetch-emails")
public class UserEmailFetchController {

    private final UserService userService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> fetchLMSUserEmails (){
        return userService.getUserLoginList();
    }
}
