package com.prodyna.conference.service;

import com.prodyna.conference.ConferenceService;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ConferenceServiceBean implements ConferenceService {

    @Inject
    private Logger log;

    @Override
    public String hello(String name) {
        log.info("Greetings to " + name );
        return "Hello, " + name;
    }

}
