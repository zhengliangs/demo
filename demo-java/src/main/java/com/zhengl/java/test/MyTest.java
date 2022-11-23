package com.zhengl.java.test;

import java.math.BigDecimal;
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
     * @author hero良
     */
    @Test
    public void t6(){
        long milli = 123;
        long days = milli / 1000 / 60 / 60 / 24;
        long daysRound = (long)Math.floor(days);
        long hours = milli / 1000 / 60 / 60 - (24 * daysRound);
        long hoursRound = (long)Math.floor(hours);
        long minutes = milli / 1000 / 60 - (24 * 60 * daysRound) - (60 * hoursRound);
        long minutesRound = (long)Math.floor(minutes);
        long seconds = milli / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound);

        StringBuilder sb = new StringBuilder();
        if(daysRound > 0){
            sb.append(daysRound).append("天");
        }
        if(hoursRound > 0){
            sb.append(hoursRound).append("时");
        }
        if(minutesRound> 0){
            sb.append(minutesRound).append("分");
        }
        if(seconds> 0){
            sb.append(seconds).append("秒");
        }
        System.out.println(sb);
    }

    /**
     * 测试如果 sdf 格式是  yyyy-M-d H:m:s，
     * 如果时间是 2021-08-11 00:00:00 format 之后是 2021-8-5 0:0:0
     * 如果时间是 2021-10-11 22:26:37 format 之后是 2021-10-11 22:26:37
     * @author hero 良
     */
    @Test
    public void t7(){
        // 2021-08-11 00:00:00
        long l = 1633962397000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d H:m:s");
        System.out.println(sdf.format(new Date(l)));
    }

    /**
     * 将科学计数法的值转为正常数
     * @author hero 良
     */
    @Test
    public void t8(){
        double num = 8.2347983984297E7;
        System.out.println(new BigDecimal(num+""));//82347983.984297
    }

    /**
     * 验证 j++ 在循环中执行赋值效果
     * @author hero良
     * @date 2022/4/26
     */
    @Test
    public void t9(){
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
     * @author hero良
     * @date 2022/7/8
     */
    @Test
    public void t10(){
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
    public void t11(){
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

}