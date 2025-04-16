package com.conference.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"user", "paper"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int technicalScore;
    private int noveltyScore;
    private String comments;
    private String confidentialComments;
    private LocalDateTime reviewDate;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    private Paper paper;

    // Getters and setters
}