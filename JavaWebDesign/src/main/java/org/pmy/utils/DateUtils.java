package org.pmy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    public static String format(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        return  sdf.format(date);

    }
}
