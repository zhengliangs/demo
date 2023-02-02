package com.zhengl.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * thenCompose 等待前一个任务执行完，把前一个任务的结果当做参数传递给下一个任务，返回下一个任务处理后的；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenCompose {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(3000);
            return "番茄炒蛋";
        }).thenComposeAsync(dish -> CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("服务员打饭");
            SmallTool.sleepMillis(100);
            return dish + " + 米饭";
        }));

        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s 好了,小白开吃", supplyAsync.join()));
    }
}
