package com.zhengl.mongodb.service;

import com.zhengl.mongodb.entity.HisData;
import com.zhengl.mongodb.entity.HisDataPerDay;
import com.zhengl.mongodb.info.MessageBody;
import com.zhengl.mongodb.info.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveMongo() throws ParseException {
        String startTime = "20230501", endTime = "20230531";
        // 2023-05-01 - 2023-05-31 所有的额日期集合
        List<String> dayBetween = getDayBetween(startTime, endTime);
        // 所有待读取数据的集合
        Set<String> collectionNames = mongoTemplate.getCollectionNames();
        log.info("共有 {} 个集合待读取.....", collectionNames.size());

        List<String> collectionNameList = collectionNames.stream().filter(c -> c.charAt(0) == 'e').collect(Collectors.toList());
        log.info("剔除完   共有 {} 个集合待读取.....", collectionNameList.size());

        for (String date : dayBetween) {
            log.info("------------开始读取 {} 的数据.....", date);
            Map<Long, List<MessageBody>> map = new HashMap<>();
            // 遍历所有的集合
            for (String collectionName : collectionNameList) {
                Criteria criteria = Criteria.where("day").is(date);
                Query query = new Query(criteria);
                // 拿到所有的数据，每条数据下面有当天所有的数据点 1440 个点
                List<HisDataPerDay> hisDataPerDays = mongoTemplate.find(query, HisDataPerDay.class, collectionName);
                if (CollectionUtils.isEmpty(hisDataPerDays)) {
                    continue;
                }
                // 遍历所有的tag点，得到1440个点
                for (HisDataPerDay perDay : hisDataPerDays) {
                    for (HisData hisData : perDay.getData_list()) {
                        MessageBody body = new MessageBody();
                        body.setQuality(1);
                        body.setValue(hisData.getValue());
                        body.setTagId(perDay.getTag());

                        if (map.containsKey(hisData.getTimeStamp())) {
                            List<MessageBody> bodyList = map.get(hisData.getTimeStamp());
                            bodyList.add(body);
                        } else {
                            List<MessageBody> bodyList = new ArrayList<>();
                            bodyList.add(body);
                            map.put(hisData.getTimeStamp(), bodyList);
                        }
                    }
                }
            }
            List<MessageData> list = new ArrayList<>();
            for (Map.Entry<Long, List<MessageBody>> entry : map.entrySet()) {
                list.add(new MessageData(String.valueOf(entry.getKey()), entry.getValue()));
            }
            Collections.sort(list, Comparator.comparing(MessageData::getTime));
            mongoTemplate.insert(list, date);
            log.info("------------{} 的数据读取完毕.....", date);
        }
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
