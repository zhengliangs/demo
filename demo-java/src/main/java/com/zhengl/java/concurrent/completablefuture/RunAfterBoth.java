package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * runAfterBoth 等待前面两个任务执行完，才会执行下一个动作，但是不会关心前面两个任务的结果，没有返回值
 * @author hero良
 * @date 2022/6/24
 */
public class RunAfterBoth {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("收到请求...");

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("保存mysql逻辑...");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(2000);
            return "mysql save succeed";
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("保存mongodb逻辑...");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(1000);
            return "mongodb save succeed";
        }), () -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("发送消息...");
        });

        cf.join();
        SmallTool.printTimeAndThread("处理完成...");
    }
}
