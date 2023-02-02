package com.zhengl.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * thenAcceptBoth 等待前面两个任务执行完，把前面两个任务的结果当做参数传递给下一个动作，没有返回值；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenAcceptBoth {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("收到请求...");

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("保存mysql逻辑...");
            SmallTool.sleepMillis(2000);
            return "mysql_id";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("保存mongodb逻辑...");
            SmallTool.sleepMillis(1000);
            return "mongo_id";
        }), (mysql, mongo) -> {
            SmallTool.printTimeAndThread("拿到id干点什么吧...");
            SmallTool.printTimeAndThread(mysql);
            SmallTool.printTimeAndThread(mongo);
        });

        cf.join();
        SmallTool.printTimeAndThread("处理完成...");
    }
}
