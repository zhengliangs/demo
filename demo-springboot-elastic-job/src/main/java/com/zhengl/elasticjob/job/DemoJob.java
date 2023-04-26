package com.zhengl.elasticjob.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("  开始执行定时任务...");
    }
}
