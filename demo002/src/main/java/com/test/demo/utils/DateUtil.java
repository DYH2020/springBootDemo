package com.test.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final String[] WEEK_DAYS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    private static final String[] WEEK_DAYS_SHORT = {"日", "一", "二", "三", "四", "五", "六"};

    private static final String[] WEEK_DAYS_MIDDLE = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    /**
     * 将时间戳转换成日期字符串格式
     * @param timestamp 时间戳
     * @param pattern 日期格式
     * @return
     */
    public static String convertTimestampToDateString(long timestamp, String pattern) {
        Date date = new Date(timestamp);
        return convertToString(date, pattern);
    }

    public static String convertToString(Date date){
        return convertToString(date, null);
    }

    public static String convertToString(Date date, String pattern){
        if(StringHelper.isNullOrEmpty(pattern)){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 计算当前时间和指定时间之间相差的小时
     *
     * @param smdate
     *            指定的时间
     * @throws ParseException
     */
    public static int hourBetween(String smdate) {
        Date start = new Date();
        Date end = stringToDate(smdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();

        long between_days = (time2 - time1) / (1000 * 3600);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * String转Date
     *
     * @param strDate
     * @return
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (null == strDate) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String strDate) {
        return stringToDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 当前日期是星期几
     * @param calendar
     * @return
     */
    public static String getDayOfWeek(Calendar calendar) {
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (index < 0) {
            index = 0;
        }
        return WEEK_DAYS[index];
    }

    /**
     * 当前日期是星期（缩略）
     * @param calendar
     * @return
     */
    public static String getDayOfWeekShort(Calendar calendar) {
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (index < 0) {
            index = 0;
        }
        return WEEK_DAYS_SHORT[index];
    }

    /**
     * 当前日期是星期（缩略）
     * @param calendar
     * @return
     */
    public static String getDayOfWeekMiddle(Calendar calendar) {
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (index < 0) {
            index = 0;
        }
        return WEEK_DAYS_MIDDLE[index];
    }
}
