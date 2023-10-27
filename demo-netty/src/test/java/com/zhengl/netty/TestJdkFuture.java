package com.zhengl.netty;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class TestJdkFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("执行逻辑...");
                Thread.sleep(1000);
                return 50;
            }
        });

        log.debug("等待结果...");
        Integer integer = future.get();
        log.debug("结果 = {}", integer);
    }
}
