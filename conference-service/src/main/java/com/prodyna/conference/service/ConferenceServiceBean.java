package com.prodyna.conference.service;

import com.prodyna.conference.Conference;
import com.prodyna.conference.ConferenceService;
import com.prodyna.conference.common.monitoring.Monitored;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Monitored
@Stateless
public class ConferenceServiceBean implements ConferenceService {

    @Inject
    private Logger log;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Conference create(Conference conf) {
        em.persist(conf);
        return conf;
    }

    @Override
    public List<Conference> readAll() {
        return em.createNamedQuery("all").getResultList();
    }

    @Override
    public Conference readById(String id) {
        return em.find(Conference.class, id);
    }

    @Override
    public Conference readByName(String name) {
        return em.createNamedQuery("byName", Conference.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public void update(String id, Conference conf) {
        conf.setId(id);
        em.merge(id);
    }

    @Override
    public void delete(String id) {
        Conference conf = readById(id);
        em.remove(conf);
    }
}
