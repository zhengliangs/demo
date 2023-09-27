package com.zhengl.mongodb;

import com.zhengl.mongodb.info.MessageBody;
import com.zhengl.mongodb.info.MessageData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class SystemServerApplicationTests1 {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void test() throws ParseException {
        String startTime = "20230501", endTime = "20230531";
        // 2023-05-01 - 2023-05-31 所有的额日期集合
        List<String> dayBetween = getDayBetween(startTime, endTime);
        for (String date : dayBetween) {
            List<String> minuteList = getMinute(date);
            for (String minute : minuteList) {
                Query query = Query.query(Criteria.where("time").is(minute));
                MessageData messageData = mongoTemplate.findOne(query, MessageData.class, date);
            }
            Query query = new Query();
            Field fields = query.fields();
            fields.include("time");
            List<MessageData> messageData = mongoTemplate.find(query, MessageData.class, date);
            Set<String> set = new HashSet<>();
            for (MessageData data : messageData) {
                set.add(data.getTime());
            }
            List<String> list = new ArrayList<>(set);
            System.out.println(date + "    1     list = " + list.size());
            list.removeAll(minuteList);
            for (String s : list) {
                Query deleteQuery = Query.query(Criteria.where("time").is(s));
                mongoTemplate.remove(deleteQuery, date);
            }
            System.out.println(date + "   list = " + list.size());

        }
        System.out.println("dayBetween = " + dayBetween);
    }

    private List<String> getMinute(String time) {
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar tt = Calendar.getInstance();
        tt.setTime(date);
        Calendar t2 = Calendar.getInstance();
        t2.setTime(date);
        t2.add(Calendar.DAY_OF_MONTH, 1);
        for (; tt.compareTo(t2) < 0; tt.add(Calendar.MINUTE, 1)) {
            dateList.add(String.valueOf(tt.getTime().getTime()));
        }
        return dateList;
    }

    /**
     * 处理变比和偏移量
     * @author hero良
     * @date 2022/5/9
     */
    public void ratioOffset(MessageBody body, String ratioOffset){
        // 配置了变比、偏移量，先计算
        if(!StringUtils.isEmpty(ratioOffset)){
            calculateRatioOffset(ratioOffset, body);
        }
    }

    /**
     * 计算变比、偏移量
     * @author hero良
     * @date 2022/6/2
     */
    private void calculateRatioOffset(String ratioOffset, MessageBody body){
        String[] split = ratioOffset.split(",");
        double value = body.getValue();
        double offset = Double.parseDouble(split[1]);
        if (offset != 0.0){
            value -= offset;
        }
        double ratio = Double.parseDouble(split[0]);
        if (ratio != 1.0){
            value /= ratio;
        }
        body.setValue(value);
    }

    public static List<String> getDayBetween(String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<String> list = new ArrayList<>();
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        while (startDate.getTime() <= endDate.getTime()) {
            list.add(sdf.format(startDate));
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE, 1);
            startDate = calendar.getTime();
        }
        return list;
    }

}
