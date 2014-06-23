package com.prodyna.conference.common.producer;

import com.prodyna.conference.common.monitoring.Monitored;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Monitored
public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager produce() {
        return entityManager;
    }
}
