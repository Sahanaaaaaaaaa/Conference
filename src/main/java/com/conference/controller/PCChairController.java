package com.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.conference.service.ConferenceService;    // Changed from service.impl
import com.conference.service.PaperService;         // Changed from service.impl
import com.conference.model.Conference;

@Controller
@RequestMapping("/pc-chair")
public class PCChairController {
    private final ConferenceService conferenceService;
    private final PaperService paperService;

    public PCChairController(ConferenceService conferenceService, PaperService paperService) {
        this.conferenceService = conferenceService;
        this.paperService = paperService;
    }

    @PostMapping("/conferences/create")
    public String createConference(@ModelAttribute Conference conference) {
        conferenceService.createConference(conference);
        return "redirect:/pc-chair/conferences";
    }

    @GetMapping("/conferences")
    public String listConferences(Model model) {
        model.addAttribute("conferences", conferenceService.getAllConferences());
        return "pc-chair/conferences";
    }
}