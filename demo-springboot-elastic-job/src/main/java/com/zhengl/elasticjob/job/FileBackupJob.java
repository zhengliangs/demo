package com.zhengl.elasticjob.job;

import com.zhengl.elasticjob.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 任务类
 */
@Slf4j
@Component
public class FileBackupJob implements SimpleJob {

    @Autowired
    private BusinessService businessService;

    @Override
    public void execute(ShardingContext shardingContext) {
//        String shardingParameter = shardingContext.getShardingParameter();
//        log.info("shardingParameter == {}", shardingParameter);
//
//        String jobParameter = shardingContext.getJobParameter();
//        log.info("jobParameter == {}", jobParameter);
//
//        int shardingItem = shardingContext.getShardingItem();
//        log.info("shardingItem == {}", shardingItem);
//
//        businessService.businessLogic(shardingParameter);
    }

}
