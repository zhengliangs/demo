package com.zhengl.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestEventLoopGroup {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();

        // 普通任务
        // submit | execute
        group.next().execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("ok");
        });

        // 定时任务
        group.next().scheduleAtFixedRate(() -> log.debug("ok1"), 0, 1, TimeUnit.SECONDS);
        log.debug("main");
    }
}
