package com.wj02.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        if (null == s) return null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("数据转换异常");
        }
    }
}
