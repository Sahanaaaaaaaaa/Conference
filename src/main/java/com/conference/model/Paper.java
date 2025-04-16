package com.conference.model;

import com.conference.model.enums.PaperState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = {"conference", "reviews", "authors", "reviewers"})
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String abstract_;
    private String keywords;
    private String status;
    private LocalDateTime submissionDate;

    @ManyToOne
    private User author;

    @ManyToOne
    private Conference conference;

    @OneToMany(mappedBy = "paper")
    private List<Review> reviews = new ArrayList<>();

    // Getters and setters
}