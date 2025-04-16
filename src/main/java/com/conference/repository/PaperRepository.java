package com.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.conference.model.Paper;
import com.conference.model.Conference;
import com.conference.model.User;
import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findByAuthor(User author);
    List<Paper> findByConference(Conference conference);
}