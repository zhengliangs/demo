package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * thenCompose 等待前一个任务执行完，把前一个任务的结果当做参数传递给下一个任务，返回下一个任务处理后的；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenCompose {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白进入餐厅");
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("厨师炒菜");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(3000);
            return "番茄炒蛋";
        }).thenComposeAsync(dish -> CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("服务员打饭");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(100);
            return dish + " + 米饭";
        }));

        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s 好了,小白开吃", supplyAsync.join()));
    }
}
