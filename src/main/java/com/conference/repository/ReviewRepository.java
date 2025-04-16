package com.conference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conference.model.Paper;
import com.conference.model.Review;
import com.conference.model.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewer(User reviewer);
    List<Review> findByPaper(Paper paper);
}