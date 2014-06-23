package com.prodyna.conference.test;

import com.prodyna.conference.Conference;
import com.prodyna.conference.ConferenceService;
import com.prodyna.conference.common.DateFormatter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;
import java.text.ParseException;
import java.util.List;

@RunWith(Arquillian.class)
public class CopyOfConferenceServiceTest {

    @Inject
    private Logger log;

    @Inject
    private ConferenceService conferenceService;

    @Inject
    private DatabaseCleaner databaseCleaner;

    @Inject
    private DateFormatter dateFormatter;

    @Deployment
    public static Archive<?> createArchive() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war");
        war.addAsWebInfResource(new File("src/test/resources/META-INF/beans.xml"), "beans.xml");
        war.addAsResource(new File("src/test/resources/META-INF/persistence-test.xml"), "META-INF/persistence.xml");
        war.addPackages(true, "com.prodyna.conference");
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    @InSequence(1)
    public void deleteAllConferences() {
        databaseCleaner.deleteAllConferences();
    }

    @Test
    @InSequence(2)
    public void checkNoFound() {
        Assert.assertEquals(0, conferenceService.readAll().size());
    }

    @Test
    @InSequence(3)
    public void createConference() throws ParseException {
        Conference conf = new Conference("jfs", "Java Forum Stuttgart", dateFormatter.parse("2014-06-06"), dateFormatter.parse("2014-06-08"));
        conferenceService.create(conf);
    }

    @Test
    @InSequence(4)
    public void readAll() {
        List<Conference> confs = conferenceService.readAll();
        Assert.assertEquals(1, confs.size());
        Assert.assertEquals("jfs", confs.get(0).getId());
    }

}
