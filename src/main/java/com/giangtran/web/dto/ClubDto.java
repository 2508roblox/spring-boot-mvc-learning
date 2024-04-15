package com.giangtran.web.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder


public class ClubDto {

    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
