package com.zhengl.java.concurrent.completablefuture;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.concurrent.CompletableFuture;

public class SupplyAsync {

    public static void main(String[] args) {
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白进入餐厅");
        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        // supplyAsync 开启异步操作
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("厨师炒菜");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(1000);
            com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("厨师打饭");
            com.zhengl.concurrent.completablefuture.SmallTool.sleepMillis(100);
            return "番茄炒蛋 + 米饭 做好了";
        });

        com.zhengl.concurrent.completablefuture.SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s ,小白开吃", cf.join()));
    }
}
