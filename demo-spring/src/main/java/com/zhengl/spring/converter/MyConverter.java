package com.zhengl.spring.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String, Date> {

    private SimpleDateFormat pattern;

    public SimpleDateFormat getPattern() {
        return pattern;
    }

    public void setPattern(SimpleDateFormat pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String source) {
        Date date;
        try {
            date = pattern.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
