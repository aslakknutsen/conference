package com.prodyna.conference.test;

import com.prodyna.conference.ConferenceService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;

@RunWith(Arquillian.class)
public class ConferenceServiceTest {

    @Inject
    private Logger log;

    @Inject
    private ConferenceService conferenceService;

    @Deployment
    public static Archive<?> createArchive() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war");
        war.addAsWebInfResource(new File("src/test/resources/META-INF/beans.xml"), "classes/META-INF/beans.xml");
        war.addPackages(true, "com.prodyna.conference");
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void helloTest() {
        String result = conferenceService.hello("Java Forum Stuttgart");
        Assert.assertEquals("Hello, Java Forum Stuttgart", result);
    }
}
