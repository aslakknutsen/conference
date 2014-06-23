package com.prodyna.conference.common;

import com.prodyna.conference.common.monitoring.Monitored;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Monitored
public class DateFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public Date parse( String date ) throws ParseException {
        return new SimpleDateFormat( DATE_FORMAT ).parse(date);
    }

}
