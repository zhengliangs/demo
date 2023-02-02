package com.zhengl.java.concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

public class SupplyAsync {

    public static void main(String[] args) {
        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        // supplyAsync 开启异步操作
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(1000);
            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMillis(100);
            return "番茄炒蛋 + 米饭 做好了";
        });

        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s ,小白开吃", cf.join()));
    }
}
