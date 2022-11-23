package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * applyToEither 获取最先完成的任务
 * 当任意一个CompletableFuture完成的时候，fn会被执行，fn的返回值会当作新的CompletableFuture<U>的计算结果。
 *
 * @author hero良
 * @date 2022/6/24
 */
public class ApplyToEither {

    public static void main(String[] args) {
        Random random = new Random();

        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白走出餐厅");
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白在等 700 || 800 路公交车");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("700 来的路上");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(random.nextInt(10000));
            return "700路到了";
        }).applyToEitherAsync(CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("800 来的路上");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(random.nextInt(10000));
            return "800路到了";
        }),firstComeBus -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread(firstComeBus);
            if (firstComeBus.startsWith("700")) {
                throw new RuntimeException("撞树了……");
            }
            return firstComeBus;
        }).exceptionally(e -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread(e.getMessage());
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白叫出租车");
            return "出租车 叫到了";
        });

        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白等公交的时候在刷视频");
        SmallTool.printTimeAndThread(String.format("%s ，小白坐车回家", cf.join()));
    }
}
