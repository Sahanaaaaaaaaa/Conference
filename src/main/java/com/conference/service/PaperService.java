package com.conference.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.conference.repository.PaperRepository;
import com.conference.model.Paper;
import com.conference.model.Conference;
import com.conference.model.User;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PaperService {
    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public Paper submitPaper(Paper paper, User author) {
        paper.setAuthor(author);
        paper.setStatus("SUBMITTED");
        paper.setSubmissionDate(LocalDateTime.now());
        return paperRepository.save(paper);
    }

    public List<Paper> getPapersByAuthor(User author) {
        return paperRepository.findByAuthor(author);
    }

    public List<Paper> getPapersByConference(Conference conference) {
        return paperRepository.findByConference(conference);
    }
}