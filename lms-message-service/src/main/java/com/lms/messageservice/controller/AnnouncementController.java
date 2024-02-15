package com.lms.messageservice.controller;

import com.lms.messageservice.dto.AnnouncementRequestDto;
import com.lms.messageservice.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postAnnouncement (@RequestBody AnnouncementRequestDto announcementRequestDto ){

        return  announcementService.postAnnouncement(announcementRequestDto);


    }
}
