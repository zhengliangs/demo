package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * thenAcceptBoth 等待前面两个任务执行完，把前面两个任务的结果当做参数传递给下一个动作，没有返回值；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenAcceptBoth {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("收到请求...");

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("保存mysql逻辑...");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(2000);
            return "mysql_id";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("保存mongodb逻辑...");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(1000);
            return "mongo_id";
        }), (mysql, mongo) -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("拿到id干点什么吧...");
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread(mysql);
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread(mongo);
        });

        cf.join();
        SmallTool.printTimeAndThread("处理完成...");
    }
}
