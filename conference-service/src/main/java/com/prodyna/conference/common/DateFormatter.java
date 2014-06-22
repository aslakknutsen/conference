package com.prodyna.conference.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public Date parse( String date ) throws ParseException {
        return new SimpleDateFormat( DATE_FORMAT ).parse(date);
    }

}
