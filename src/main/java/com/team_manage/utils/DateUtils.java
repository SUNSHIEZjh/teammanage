package com.team_manage.utils;

import com.team_manage.common.Constant;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 工具类
 *
 * @author XXX
 */
public class DateUtils {

    private DateUtils() {
        throw new IllegalStateException("DateUtils class");
    }

    /**
     * 日期转字符串
     *
     * @param date 传入日期
     * @return String类型日期
     */
    public static String dateToString1(Date date) {
        //格式化日期时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }


    /**
     * 日期转字符串
     *
     * @param date 传入日期
     * @return String类型日期
     */
    public static String dateToString(Date date) {
        //格式化日期时间
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }


    /**
     * 日期转字符串
     *
     * @param date 传入日期
     * @return String类型日期
     */
    public static String dateToString2(Date date) {
        //格式化日期时间
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_YYYY_MM_DD);
        return sdf.format(date);
    }

    /**
     * 传入出生年月计算日期
     *
     * @param userBirthday 用户出生年月日
     * @return
     */
    public static int getAge(LocalDate userBirthday) {
        // 转化成date
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = userBirthday.atStartOfDay().atZone(zone).toInstant();
        Date birth = Date.from(instant);
        // 计算时间
        Calendar cal = Calendar.getInstance();
        int thisYear = cal.get(Calendar.YEAR);
        int thisMonth = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birth);
        int birthYear = cal.get(Calendar.YEAR);
        int birthMonth = cal.get(Calendar.MONTH);
        int birthdayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int age = thisYear - birthYear;
        // 未足月
        if (thisMonth <= birthMonth) {
            // 当月
            if (thisMonth == birthMonth) {
                // 未足日
                if (dayOfMonth < birthdayOfMonth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 设置时间格式
     *
     * @param date 传入时间
     * @param type 0、设置为00:00:00:000 1、设置为23:59:59:999
     * @return Date
     */
    public static Date setDate(Date date, Integer type) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }
        if (Constant.INTEGER_ZERO.equals(type)) {
            // 设置开始时间为当天的0点0分0秒
            Calendar startCal = Calendar.getInstance();
            startCal.setTime(date);
            startCal.set(Calendar.HOUR_OF_DAY, 0);
            startCal.set(Calendar.MINUTE, 0);
            startCal.set(Calendar.SECOND, 0);
            startCal.set(Calendar.MILLISECOND, 0);
            date = startCal.getTime();
        }
        if (Constant.INTEGER_ONE.equals(type)) {
            // 设置结束时间为当天的23时59分59秒
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(date);
            endCal.set(Calendar.HOUR_OF_DAY, 23);
            endCal.set(Calendar.MINUTE, 59);
            endCal.set(Calendar.SECOND, 59);
            endCal.set(Calendar.MILLISECOND, 999);
            date = endCal.getTime();
        }
        return date;
    }

    /**
     * 辅助方法：在指定日期上增加指定年数
     *
     * @param date  日期
     * @param years 年
     * @return Date
     */
    public static Date addYears(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    /**
     * 输出增加天数的时间
     *
     * @param date 传入日期
     * @param days 天数
     * @return
     */
    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 时间格式
     *
     * @param date String类型时间
     * @return Date
     */
    @SneakyThrows
    public static Date stringDateToDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        date = date.replace("/", "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_YYYY_MM_DD);
        return simpleDateFormat.parse(date);
    }


    /**
     * 获取两个日期(yyyy-MM-dd)中间的日期集合,包含开始日期和结束日期
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return List<String>
     */
    public static List<String> getIntermediateDate(String startDate, String endDate) {
        List<String> days = new ArrayList<>();
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_YYYY_MM_DD);
        try {
            //将开始日期设置给calendar
            startTime.setTime(sdf.parse(startDate));
            //日期减1，包含开始日期
            startTime.add(Calendar.DATE, -1);
            //将结束日期设置给calendar
            endTime.setTime(sdf.parse(endDate));
            while (startTime.before(endTime)) {
                startTime.add(Calendar.DAY_OF_MONTH, 1);
                days.add(sdf.format(startTime.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }
}
