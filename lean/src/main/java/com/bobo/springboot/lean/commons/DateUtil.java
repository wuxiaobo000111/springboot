package com.bobo.springboot.lean.commons;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

;

public class DateUtil {


    private static final String date_format = "MMM dd, yyyy hh:mm:ss a";
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();
    private static Pattern patternHHmm = Pattern.compile("^([01][0-9]|2[0-3])([0-5][0-9])$");
    private static Pattern patternLeapYear = Pattern.compile("^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30|31)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)0229)$");
    public static DateFormat getDateFormat()
    {
        DateFormat df = threadLocal.get();
        if(df==null){
            df = new SimpleDateFormat(date_format, Locale.US);
            threadLocal.set(df);
        }
        return df;
    }

    public static String formatDate(Date date) throws ParseException {
        return getDateFormat().format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return getDateFormat().parse(strDate);
    }





    private static String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    public static String date2String(Date date) throws Exception{
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }
    public static String date2String2(Date date) throws Exception{
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String date2String3(Date date) throws Exception{
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    public static String date2String4(Date date) throws Exception{
        return new SimpleDateFormat("MM/dd").format(date);
    }

    public static String date2String5(Date date) throws Exception{
        return new SimpleDateFormat("HH:mm").format(date);
    }
    public static String date2String6(Date date) throws Exception{
        return new SimpleDateFormat("HHmm").format(date);
    }
    public static String date2String7(Date date) throws Exception{
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyyMMddHHmm").format(date);
    }

    public static String date2String8(Date date) throws Exception{
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String date2String9(Date date) throws Exception{
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static Date string2Date(String str) throws ParseException {
        return string2Date(str, "yyyyMMddHHmmss");
    }
    public static Date string2Date2(String str) throws ParseException{
        return string2Date(str, "yyyyMMddHHmm");
    }
    public static Date String2Date3(String str) throws Exception{
        return string2Date(str, "yyyy-MM-dd HH:mm:ss");
    }
    public static Date string2DateFormat(String str) throws Exception{
        return string2Date(str,"yyyyMMdd");
    }

    /**
     *  返回格式  yyyyMMdd
     * @return
     */
    public static String getMaxDate(String[] strDates) throws Exception {

        if(strDates.length<=0){
            return null;
        }
        Date maxDate = string2DateFormat(strDates[0]);
        String maxString = strDates[0];
        for(String str: strDates){
            if(maxDate.before(string2DateFormat(str))){
                maxString=str;
                maxDate = string2DateFormat(str);
            }
        }
        return maxString;
    }

    /**
     * 对日期集合进行排序
     * @return
     */
    public static String sortDate(List<String> dates){
        if(dates==null){
            return null;
        }
        Collections.sort(dates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    Date one = string2DateFormat(o1);
                    Date two = string2DateFormat(o2);
                    if(one.getTime()<two.getTime()){
                        return -1;
                    }

                    if(one.getTime()>two.getTime()){
                        return 1;
                    }
                    return 0;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<dates.size();i++){
            sb.append(dates.get(i)+",");
        }

        return sb.length()!=0?sb.substring(0,sb.length()-1):"";
    }



    public static String getCheckTime(int... time){
        StringBuilder sb = new StringBuilder();
        for(int i:time){
            sb.append(i<10?"0"+i:i);
        }
        return sb.toString();
    }

    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    /**
     * 格式化为MM月dd日（" + 星期几 + "）HH:mm
     * @param date yyyyMMddHHmm
     * @return
     * @throws Exception
     */
    public static String string2String1(String date) throws Exception {
        if (date == null) {
            return null;
        }
        Date d = null;
        try {
            d = string2Date2(date);
        } catch (Exception e) {
        }
        String week = getWeek(d);
        return format(d,"MM月dd日（" + week + "）HH:mm");
    }
    public static Date string2Date(String str, String formatter) throws ParseException {
        return new SimpleDateFormat(formatter).parse(str);
    }

    /**
     * onAir实体日期格式化
     * @param datestr
     * @return
     * @throws Exception
     */
    public static String onAirDateStrFormat(String datestr) throws Exception{
        if(datestr.split(" ").length == 1) {
            return datestr;
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(String2Date3(datestr));
    }

    public static Date getTodayTime(Time time){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime(time);

        cal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, timeCal.get(Calendar.SECOND));

        return cal.getTime();
    }

    public static String format(Date date, String formatter){
        try {
            DateFormat sdf = new SimpleDateFormat(formatter);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String format(String str, String formatter){
        String resultString = "";
        try {
            resultString = new SimpleDateFormat(formatter).format(string2Date(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static int getPassedYears(String from, String formatter){
        if (StringUtils.isEmpty(from)) {
            return 0;
        }
        int years = 0;
        try {
            years = (int) Math.ceil(((double)(System.currentTimeMillis() - string2Date(from, formatter).getTime()) / (1000*60*60*24) / 365));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return years;
    }


    public static Date getSpecificTime(Date date, int hour,
                                       int minute, int second, int millisecond) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, millisecond);
        return cal.getTime();
    }

    /**
     * 倒计时取得
     *
     * @param targetDate
     * @return
     */
    public static int getCountDown(Date targetDate){
        return (int) ((targetDate.getTime() -System.currentTimeMillis()) / 1000);
    }


    /**
     * 判断是否过期
     *
     * @param date
     * @return
     */
    public static boolean isTimeout(Date date) {
        if(date.compareTo(new Date()) < 0){
            return true;
        }
        return false;
    }

    /**
     * 判断是否大于等于
     * @param
     * @return
     */
    public static boolean isGreatEqualThan(Date date1, Date date2) {
        if(date1.compareTo(date2) >= 0){
            return true;
        }
        return false;
    }

    /**
     * 只比较小时分钟，不比较日期
     * 判断inputDate的小时分钟是否在stdDate的小时分钟的前后的hours小时内
     *
     * @param inputDate
     * @param stdDate
     * @param hours
     * @return
     */
    public static boolean isHourBetween(Date inputDate, Date stdDate, int hours) {

        Calendar inputCalendar = Calendar.getInstance();
        inputCalendar.setTimeInMillis(inputDate.getTime());
        Calendar stdCalendar = Calendar.getInstance();
        stdCalendar.setTimeInMillis(stdDate.getTime());

        stdCalendar.add(Calendar.HOUR_OF_DAY, -1 * hours);
        int p = inputCalendar.get(Calendar.HOUR_OF_DAY);
        int start = stdCalendar.get(Calendar.HOUR_OF_DAY);
        stdCalendar.add(Calendar.HOUR_OF_DAY, 2 * hours);
        int end = stdCalendar.get(Calendar.HOUR_OF_DAY);
        if (start > end ) {
            end = 24 + end;
            if (p <= 1) {
                p = p + 24;
            }
        }

        if (p * 60 + inputCalendar.get(Calendar.MINUTE) < start * 60 + stdCalendar.get(Calendar.MINUTE)
                || end * 60 + stdCalendar.get(Calendar.MINUTE) < p * 60 + inputCalendar.get(Calendar.MINUTE)) {
            return false;
        }
        return true;
    }

    /**
     * 判断两个时间相差在某个分钟范围内
     *
     * @param inputDate
     * @param stdDate
     * @param minutes
     * @return
     */
    public static boolean isMinuteBetween(Date inputDate, Date stdDate, int minutes) {

        Calendar inputCalendar = Calendar.getInstance();
        inputCalendar.setTimeInMillis(inputDate.getTime());
        Calendar stdCalendar = Calendar.getInstance();
        stdCalendar.setTimeInMillis(stdDate.getTime());
        stdCalendar.add(Calendar.MINUTE, -1 * minutes);
        int p = inputCalendar.get(Calendar.HOUR_OF_DAY);
        int start = stdCalendar.get(Calendar.HOUR_OF_DAY);
        stdCalendar.add(Calendar.MINUTE, 2 * minutes);
        int end = stdCalendar.get(Calendar.HOUR_OF_DAY);
        if (start > end ) {
            end = 24 + end;
            if (p <= 1) {
                p = p + 24;
            }
        }

        if (p * 60 + inputCalendar.get(Calendar.MINUTE) < start * 60 + stdCalendar.get(Calendar.MINUTE)
                || end * 60 + stdCalendar.get(Calendar.MINUTE) < p * 60 + inputCalendar.get(Calendar.MINUTE)) {
            return false;
        }
        return true;
    }

    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if(week == 0){
            week = 7;
        }
        return week;
    }
    //当前时间距离明日0点的时间差（毫秒）
    public static long getMillisBetweenNowAndTomorrow0H(){

        //当前时间距离明日0点的时间差（毫秒）
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTimeInMillis() - System.currentTimeMillis();
    }

    /**
     * 设置时间点到多少天之间的时间差（秒）
     * @param date 时间点
     * @param dayNum  1就是次日凌晨0点
     * @return
     */
    public static Integer getSecTimeDifference(Date date, Integer dayNum){

        //设置时间点到多少天之间的时间差（秒）
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, dayNum);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Long millis = cal.getTimeInMillis() - date.getTime();
        return millis.intValue() / 1000;
    }

    /**
     * 取得本周一日期
     *
     * @return
     */
    public static Date getThisWeekMonday(Date date) {
        //本周一
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1); //解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获得两个日期的天数差
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int compareDayOfYear(Date date1, Date date2, int diff){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal2.setTime(date2);
        cal2.add(Calendar.DAY_OF_YEAR, diff);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        return cal1.compareTo(cal2);
    }

    /**
     * 计算今天是今年的第几天
     * @param date
     * @return
     */
    public static int calcuDayNumWithYear(Date date) {
        int dateSum = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(date);
        int year = Integer.valueOf(dateStr.substring(0,4));
        int month = Integer.valueOf(dateStr.substring(5,7));
        int day = Integer.valueOf(dateStr.substring(8,10));
        //循环验证经过的月份的天数
        for (int i = 1; i < month; i++){
            switch(i){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:dateSum += 31; break;
                case 4: case 6: case 9: case 11:dateSum += 30; break;
                case 2:
                    //对闰年的日期进行计算
                    if(((year % 4 == 0) & (year % 100 != 0)) | (year % 400 == 0)){
                        dateSum += 29;
                    }else {
                        dateSum += 28;
                    }
                    break;
                default:
            }
        }
        dateSum = dateSum + day;
        return dateSum;

    }

    /**
     * 当前时间加上传入秒数
     * @param date
     * @param x
     * @return
     */
    public static Date addDateMinut(Date date, int x) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, x);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 当前时间加上传入天数
     * @param date
     * @param x
     * @return
     */
    public static Date addDateDay(Date date, int x) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, x);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 当前时间加上传入天数
     * @param date
     * @param x
     * @return
     */
    public static Date addDateDayWithZero(Date date, int x) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, x);// 24小时制
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        date = cal.getTime();
        return date;
    }

    /**
     * 当前时间加上传入时间
     * @param date
     * @param x
     * @return
     */
    public static Date addDateField(Date date, int x, int field) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, x);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 当前时间加上传入时间
     * @param date
     * @param
     * @return
     */
    public static Date getLastTimeOfDay(Date date) {
        if (null == date) {
            return null;
        }
        return DateUtil.getSpecificTime(date, 23, 59, 59, 999);
    }

    /**
     * 两时间相差秒数
     * @param date1
     * @param date2
     * @return
     */
    public static int timeAbsolute(Date date1, Date date2) {
        return (int) Math.abs((date1.getTime() -date2.getTime()) / 1000);
    }
    /**
     * 获取七天格式日期：2016-08-03 09:21
     * @param plan_start_time hhmm
     * @return
     * @throws ParseException
     */
    public static List<Date> getFormatedSevenDays(String plan_start_time) throws ParseException {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmm");
        String hh=plan_start_time.substring(0, 2);
        String mm=plan_start_time.substring(2, 4);
        String firstStr=df.format(date)+hh+mm;
        Date firstDay=df1.parse(firstStr);
        List<Date> list=new ArrayList<Date>();
        list.add(firstDay);
        Calendar cal=Calendar.getInstance();
        cal.setTime(firstDay);
        Date nextDate=null;
        String nextDateStr=null;
        for (int i = 0; i < 6; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            nextDate=cal.getTime();
            nextDateStr=df1.format(nextDate);
            nextDate=df1.parse(nextDateStr);
            list.add(nextDate);
        }
        return list;
    }
    /**
     * 获取星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 获取星期几
     * @param date  yyyyMMdd
     * @return
     */
    public static String getWeek(String date){
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        Date newDate = null;
        try {
            newDate = string2DateFormat(date);
        } catch (Exception e) {
            return null;
        }

        return getWeek(newDate);
    }
    /**
     * 获取今天   星期如
     * 	 8/5  8/7
     * @param date
     * @return
     */
    public static String getFormatedDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
//    	cal.setTime(new Date());
//    	int today=cal.get(Calendar.DAY_OF_MONTH);
        DateTime today=new DateTime();
        String dateStr=null;
        if(day==today.getDayOfMonth()){
            dateStr="今天";
        }else if(day==today.plusDays(1).getDayOfMonth()){
            dateStr="明天";
        }else{
            dateStr=month+"/"+day;
        }
        String formatedDateStr=dateStr+"("+getWeek(date)+")";
        return formatedDateStr;
    }

    /**
     * 验证 时分格式 HHmm
     * @param hhmmDate
     * @return
     */
    public static boolean ckHHmm(String hhmmDate) {
        if (StringUtils.isEmpty(hhmmDate)) {
            return false;
        }
        //首数字为1后可跟0-9 首为2后可跟0-3

        Matcher matcher = patternHHmm.matcher(hhmmDate);
        return matcher.matches();
    }

    /**
     * 验证 日期格式 yyyyMMdd
     * 支持多个日期格式 用逗号分割
     * @param yyyyMMddDate
     * @return
     */
    public static boolean ckYyyyMMdd(String yyyyMMddDate) {
        if (StringUtils.isEmpty(yyyyMMddDate)) {
            return false;
        }
        String[] strSplit = StringUtils.split(yyyyMMddDate,",");
        for (String str : strSplit) {
            //验证了全面平闰年
            Matcher matcher = patternLeapYear.matcher(str);
            if (matcher.matches() == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * TODO 临时 之后要优化
     * 根据传入日期 yyyyMMdd获取星期对应的十进制
     * 主要用户  用户push日期提醒
     * @param publish_date 可传入多个日期 逗号分隔
     * @return
     */
    public static Integer get10ByWeek(String publish_date) {
        Integer num = 0;
        if (StringUtils.isEmpty(publish_date)) {
            return null;
        }
        String[] dateSplit = publish_date.split(",");
        for (String date : dateSplit) {
            String xq = getWeek(date);
            switch (xq) {
                case "星期一" :
                    num += 2;
                    break;
                case "星期二" :
                    num += 4;
                    break;
                case "星期三" :
                    num += 8;
                    break;
                case "星期四" :
                    num += 16;
                    break;
                case "星期五" :
                    num += 32;
                    break;
                case "星期六" :
                    num += 64;
                    break;
                case "星期日" :
                    num += 128;
                    break;
                default:
            }
        }
        return num;
    }

//	public static String getPlanStartTime(Integer timeInterVal, Ride ride) throws Exception{
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MINUTE, timeInterVal);
//		String plan_start_time = "";
//		if (cal.getTime().compareTo(ride.getPlanStartTime()) < 0){
//			plan_start_time = DateUtil.date2String(ride.getPlanStartTime());
//		}else{
//			cal = Calendar.getInstance();
//			Integer minute = cal.get(Calendar.MINUTE);
//			if (minute>55 && minute<=59){
//				cal.set(Calendar.MINUTE,0);
//				cal.add(Calendar.HOUR_OF_DAY,1);
//			}else if (minute%10 < 5){
//				cal.set(Calendar.MINUTE,minute-(minute%10)+5);
//			}else if (minute%10 >5 ){
//				cal.set(Calendar.MINUTE,minute-(minute%5)+5);
//			}
//			cal.add(Calendar.MINUTE,15);
//			plan_start_time = DateUtil.date2String(cal.getTime());
//		}
//		return plan_start_time;
//	}

    public static void main(String[] args) throws Exception {

        String[] str = {"20170515","20170514","20170519","20170517"};
        System.out.println(getMaxDate(str));

		/*Calendar cal = Calendar.getInstance();
		cal.set(2017,1-1,1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calcuDayNumWithYear(cal.getTime()));*/
		/*Calendar i1 = Calendar.getInstance();
		Calendar s2 = Calendar.getInstance();
		i1.set(Calendar.HOUR_OF_DAY, 1);
		i1.set(Calendar.MINUTE, 10);
		s2.set(Calendar.HOUR_OF_DAY, 0);
		s2.set(Calendar.MINUTE, 10);
		System.out.println(isHourBetween(i1.getTime(), s2.getTime(), 1));
		*/
//		System.out.println(compareDayOfYear(string2Date("20151106000000"), string2Date("20151103230000"), 3));
    }

    public static int get(Date inputTime, int Field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputTime);

        return cal.get(Field);
    }
}
