package com.prodyna.conference.service;

import com.prodyna.conference.Conference;
import com.prodyna.conference.ConferenceService;
import com.prodyna.conference.common.monitoring.Monitored;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import java.util.List;

@Monitored
@Stateless
public class ConferenceServiceBean implements ConferenceService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Override
    @POST
    public Conference create(Conference conf) {
        // em.persist(conf);
        return conf;
    }

    @Override
    @GET
    public List<Conference> readAll() {
        return em.createNamedQuery("all").getResultList();
    }

    @Override
    @GET
    @Path("{id}")
    public Conference readById(@PathParam("id") String id) {
        return em.find(Conference.class, id);
    }

    @Override
    @GET
    @Path("name/{name}")
    public Conference readByName(@PathParam("name") String name) {
        return em.createNamedQuery("byName", Conference.class).setParameter("name", name).getSingleResult();
    }

    @Override
    @PUT
    @Path("{id}")
    public void update(@PathParam("id") String id, Conference conf) {
        conf.setId(id);
        em.merge(id);
    }

    @Override
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        Conference conf = readById(id);
        em.remove(conf);
    }
}
