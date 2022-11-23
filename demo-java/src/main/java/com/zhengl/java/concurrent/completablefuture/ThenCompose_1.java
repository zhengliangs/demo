package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

public class ThenCompose_1 {

    // thenCompose 厨师和服务员A、服务员B在同一个线程
    // thenComposeAsync 厨师和服务员A在同一个线程，服务员B在一个线程
    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白进入餐厅");
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("厨师炒菜");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(200);
            return "番茄炒蛋";
        }).thenComposeAsync(dish -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("服务员A 准备打饭，但是被领导叫走，打饭交接给服务员B");

            return CompletableFuture.supplyAsync(() -> {
                com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("服务员B 打饭");
                com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(100);
                return dish + " + 米饭";
            });
        });

        SmallTool.printTimeAndThread(cf.join() + " 好了，开饭");
    }
}
