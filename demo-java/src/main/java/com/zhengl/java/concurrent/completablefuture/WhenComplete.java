package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * whenComplete 等待前一个任务执行完，把前一个任务的结果作为参数传递给下一个任务，返回第一个任务的结果
 * @author hero良
 * @date 2022/6/24
 */
public class WhenComplete {

    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(2000);
            return "123";
        }).whenComplete((a, q) -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread(a);
        });
        String join = cf.join();
        SmallTool.printTimeAndThread(join);
    }
}
