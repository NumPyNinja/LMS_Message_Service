package com.lms.messageservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequestDto {
    private String senderEmail;
    private String content;
    private Date startDate;
    private Date endDate;
}
