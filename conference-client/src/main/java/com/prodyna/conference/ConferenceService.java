package com.prodyna.conference;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface ConferenceService {
    public String hello(String name);
}
