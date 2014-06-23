package com.prodyna.conference.test;

import com.prodyna.conference.common.monitoring.Monitored;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Monitored
@Stateless
public class DatabaseCleaner {

    @Inject
    private Logger log;

    @PersistenceContext
    private EntityManager entityManager;

    public void deleteAllConferences() {
        log.warn("Deleting all conferences");
        entityManager.createQuery("delete from Conference").executeUpdate();
    }

}
