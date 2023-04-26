package com.zhengl.java.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author hero良
 */
public class MyTest {

    /**
     * 空字符串转换为数字类型的时候会抛出错误
     * java.lang.NumberFormatException: empty String 不可以转换为number类型
     */
    @Test
    public void t1() {
        String str = "";
        System.out.println(Double.parseDouble(str));
    }

    @Test
    public void t2() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 3) {
//                    continue;
                    break;
                }
                System.out.println("j******" + j);
            }
            System.out.println("i=====" + i);
        }
    }

    /**
     * 测试 assert 断言
     * 必须开启断言，否则断言不生效
     */
    @Test
    public void t3() {
        Integer t = null;
        assert t != null;
        System.out.println(t.intValue());
    }

    /**
     * 验证split(String regex, int limit)
     * limit 表示分割之后，数组的长度，为0表示不生效
     */
    @Test
    public void t4() {
        String str = "今.日.头.条";
        String[] split = str.split("\\.", 3);
        System.out.println("length == " + split.length);

        // s == 今
        // s == 日
        // s == 头.条
        for (String s : split) {
            System.out.println("s == " + s);
        }
    }

    /**
     * 测试 lastIndexOf();
     * lastIndexOf() 返回指定字符在字符串中最后出现的下标，从0开始
     */
    @Test
    public void t5() {
        String str = "de.fault.jpg";
        // 目标所在字符串中的最后下标
        System.out.println(str.lastIndexOf("."));
        // 从最后出现 . 的位置开始截取，截取到最后  .jpg
        System.out.println(str.substring(str.lastIndexOf(".")));
    }

    /**
     * 毫秒转时分秒
     *
     * @author hero良
     */
    @Test
    public void t6() {
        long milli = 123;
        long days = milli / 1000 / 60 / 60 / 24;
        long daysRound = (long) Math.floor(days);
        long hours = milli / 1000 / 60 / 60 - (24 * daysRound);
        long hoursRound = (long) Math.floor(hours);
        long minutes = milli / 1000 / 60 - (24 * 60 * daysRound) - (60 * hoursRound);
        long minutesRound = (long) Math.floor(minutes);
        long seconds = milli / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound);

        StringBuilder sb = new StringBuilder();
        if (daysRound > 0) {
            sb.append(daysRound).append("天");
        }
        if (hoursRound > 0) {
            sb.append(hoursRound).append("时");
        }
        if (minutesRound > 0) {
            sb.append(minutesRound).append("分");
        }
        if (seconds > 0) {
            sb.append(seconds).append("秒");
        }
        System.out.println(sb);
    }

    /**
     * 测试如果 sdf 格式是  yyyy-M-d H:m:s，
     * 如果时间是 2021-08-11 00:00:00 format 之后是 2021-8-5 0:0:0
     * 如果时间是 2021-10-11 22:26:37 format 之后是 2021-10-11 22:26:37
     *
     * @author hero 良
     */
    @Test
    public void t7() {
        // 2021-08-11 00:00:00
        long l = 1633962397000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d H:m:s");
        System.out.println(sdf.format(new Date(l)));
    }

    /**
     * 将科学计数法的值转为正常数
     *
     * @author hero 良
     */
    @Test
    public void t8() {
        double num = 7.260143832639999E8;
        BigDecimal bigDecimal = new BigDecimal(num + "");
        System.out.println("bigDecimal == " + bigDecimal);//82347983.984297

        BigDecimal bigDecimal1 = bigDecimal.setScale(2, RoundingMode.UP);
        System.out.println("bigDecimal1 = " + bigDecimal1);
    }

    /**
     * 验证 j++ 在循环中执行赋值效果
     *
     * @author hero良
     * @date 2022/4/26
     */
    @Test
    public void t9() {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = (j++);
        }
        // j == 0
        // 因为  j = (j++) 在栈中是先把j的值推到栈帧，然后再执行 ++ 操作
        System.out.println(j);
    }

    /**
     * 验证给定字符串是否是数字
     *
     * @author hero良
     * @date 2022/7/8
     */
    @Test
    public void t10() {
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        String str = "/";
        System.out.println("str = " + pattern.matcher(str).matches());
        String str1 = "-45";
        System.out.println("str1 = " + pattern.matcher(str1).matches());
        String str2 = "55";
        System.out.println("str2 = " + pattern.matcher(str2).matches());
        String str3 = "12%";
        System.out.println("str3 = " + pattern.matcher(str3).matches());
        String str4 = "-";
        System.out.println("str4 = " + pattern.matcher(str4).matches());
        String str5 = "";
        System.out.println("str5 = " + pattern.matcher(str5).matches());

        String str6 = "9.8";
        System.out.println("str6 = " + pattern.matcher(str6).matches());

    }

    @Test
    public void t11() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }

    /**
     * 得到两个指定日期中间的日期
     * @author hero良
     * @date 2023/3/31
     */
    @Test
    public void t12() {
        // 声明保存日期集合
        List<String> list = new ArrayList<>();
        String startTime = "2022-01-01", endTime = "2023-03-31";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                // 把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + list);
    }

    @Test
    public void t13() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        calendar.setTime(format.parse("2023-04"));
        //本月
        Calendar calendarThisMonth = (Calendar) calendar.clone();
        Date thisMonthBegin = calendarThisMonth.getTime();
        calendarThisMonth.add(Calendar.MONTH, 1);
        calendarThisMonth.add(Calendar.DATE, -1);
        Date thisMonthEnd = calendarThisMonth.getTime();

        //年度同期
        calendar.add(Calendar.YEAR, -1);
        Date preYearMonthBegin = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date preYearMonthEnd = calendar.getTime();
        System.out.println("preYearMonthEnd = " + preYearMonthEnd);

        List<Date> list = new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(format.parse("2023-04"));
        int maxDay = calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= maxDay; i++) {
            Calendar calendarDay = (Calendar) calendar1.clone();
            calendarDay.set(Calendar.DATE, i);
            list.add(calendarDay.getTime());
        }
        System.out.println("list = " + list);
    }

    @Test
    public void t14() throws ParseException {
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "44");

        List<String> list = new ArrayList<>();
        list.add("2");

        for (String str : list) {
            String s = map.get(str);
            map.remove(str);
        }
        System.out.println(map);
    }


}