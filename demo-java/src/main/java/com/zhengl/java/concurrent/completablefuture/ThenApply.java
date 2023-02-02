package com.zhengl.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * thenApply 等待前一个任务执行完，把前一个任务的结果当做参数传递给下一个任务，返回下一个任务处理后的；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenApply {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白吃好了");
        SmallTool.printTimeAndThread("小白 结账、要求开发票");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员收款 500元");
            SmallTool.sleepMillis(2000);
            return "500";
        }).thenApply(money -> {
            SmallTool.printTimeAndThread(String.format("服务员开发票 面额 %s元", money));
            SmallTool.sleepMillis(100);
            return String.format("%s元发票", money);
        });

        SmallTool.printTimeAndThread("小白 接到朋友的电话，想一起打游戏");
        SmallTool.printTimeAndThread(String.format("小白拿到%s，准备回家", cf.join()));
    }
}
