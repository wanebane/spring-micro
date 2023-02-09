package com.rivaldy.product.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FormatDate {

    public static final String fmtDateTime = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(fmtDateTime);

    public String convertLocalDateToString(LocalDateTime localDate){
        return localDate!=null ? sdfDateTime.format(convertLocalDate(localDate)) : null;
    }

    private Date convertLocalDate(LocalDateTime localDate){
        return Date.from(localDate.atZone(zoneId()).toInstant());
    }

    private ZoneId zoneId(){
        return ZoneId.systemDefault();
    }
}
