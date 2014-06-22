package com.prodyna.conference.service;

import com.prodyna.conference.ConferenceService;

import javax.ejb.Stateless;

@Stateless
public class ConferenceServiceBean implements ConferenceService {

    @Override
    public String hello(String name) {
        return null;
    }

}
