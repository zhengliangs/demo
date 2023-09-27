package com.zhengl.mongodb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@Slf4j
public class InitService implements ApplicationRunner {

    @Autowired
    private MongoService mongoService;

    @Override
    public void run(ApplicationArguments args) {
        log.info(" 开始读取mongo数据  ");
        try {
            mongoService.saveMongo();
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        log.info(" 数据读取完毕  ");
    }

}
