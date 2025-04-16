package com.conference.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.conference.repository.ConferenceRepository;
import com.conference.model.Conference;
import java.util.List;

@Service
@Transactional
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference createConference(Conference conference) {
        conference.setStatus("OPEN");
        return conferenceRepository.save(conference);
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public List<Conference> getOpenConferences() {
        return conferenceRepository.findByStatus("OPEN");
    }
}