package com.zhengl.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * ThenRun 等待前一个任务执行完，但是不会接收前一个任务的结果，也没有返回值；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenRun {

    public static void main(String[] args) {

        SmallTool.printTimeAndThread("接收到请求...");

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            SmallTool.printTimeAndThread("save data...");
            SmallTool.sleepMillis(3000);
            SmallTool.printTimeAndThread("save succeed...");
        }).thenRun(() -> {
            SmallTool.printTimeAndThread("send inform...");
        });

        cf.join();
        SmallTool.printTimeAndThread("请求处理完成...");
    }
}
