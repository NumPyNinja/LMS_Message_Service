package com.lms.messageservice.service;

import com.lms.messageservice.dto.AnnouncementRequestDto;
import com.lms.messageservice.model.Announcement;
import com.lms.messageservice.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final UserService userService;
    private final WebClient webClient;

    /**
     *
     * @param announcementRequestDto
     * creating new announcement to all users
     * @return announcementResponseDto
     */
    public String postAnnouncement(AnnouncementRequestDto announcementRequestDto){
        var announcement = mapToAnnouncement(announcementRequestDto);
        announcementRepository.save(announcement);
        return "Announcement posted successfully";

    }

    private Announcement mapToAnnouncement(AnnouncementRequestDto announcementRequestDto){
        var announcement = new Announcement();
        announcement.setSenderEmail(announcementRequestDto.getSenderEmail());
        announcement.setContent(announcementRequestDto.getContent());
        announcement.setRecipientsEmails(userService.getUserLoginList());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        announcement.setPostingTime(timestamp);
        announcement.setStartDate(announcementRequestDto.getStartDate());
        announcement.setEndDate(announcementRequestDto.getEndDate());
        return announcement;
    }

}
