package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

/**
 * thenCombine 等待前面两个任务执行完，把前面两个任务的结果当做参数传递给下一个动作，然后返回处理后的值；
 * @author hero良
 * @date 2022/6/24
 */
public class ThenCombine {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白进入餐厅");
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("番茄炒蛋好了");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(2000);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("米饭好了");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(1000);
            return "米饭";
        }), (dish, rice) -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("服务员打饭");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(100);
            return String.format("%s + %s 好了", dish, rice);
        });

        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s ,小白开吃", cf.join()));
    }
}
