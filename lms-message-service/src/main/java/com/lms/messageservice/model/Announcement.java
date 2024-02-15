package com.lms.messageservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_lms_message_announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "announcement_id")
    private Long id;

    @Column(name ="announcement_senderEmail")
    private String senderEmail;

    @Column(name = "emails")
    private List<String> recipientsEmails;

    @Column(name = "content")
    private String content;

    @Column(name = "posting_time")
    private Timestamp postingTime;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
