package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * thenAccept 等待前一个任务执行完，把前一个任务的结果当做参数传递给下一个任务，没有返回值；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenAccept {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("接收到请求...");

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("查询点什么...");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(3000);
            return "result";
        }).thenAccept(re -> {
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(1000);
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("拿到结果干点什么  " + re);
        });

        cf.join();
        SmallTool.printTimeAndThread("请求处理完成...");
    }
}
