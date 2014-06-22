package com.prodyna.conference;

import javax.ejb.Remote;

@Remote
public interface ConferenceService {
    public String hello(String name);
}
