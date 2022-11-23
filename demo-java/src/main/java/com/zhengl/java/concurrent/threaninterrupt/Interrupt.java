package com.zhengl.java.concurrent.threaninterrupt;

import com.zhengl.concurrent.completablefuture.SmallTool;

import java.util.Random;

public class Interrupt {

    public static void main(String[] args) {

        Thread two = new Thread(() -> {
            SmallTool.printTimeAndThread("卡丁2号 准备过桥");
            SmallTool.printTimeAndThread("发现1号在过，开始等待");
            try {
                Thread.sleep(3000);
                SmallTool.printTimeAndThread("等待结束  卡丁2号 开始过桥");
            } catch (InterruptedException e) {
                SmallTool.printTimeAndThread("卡丁2号 开始过桥");
            }
            SmallTool.printTimeAndThread("卡丁2号 过桥完毕");
        });

        Thread one = new Thread(() -> {
            SmallTool.printTimeAndThread("卡丁1号 准备过桥");
            int timeSpend = new Random().nextInt(500) + 1000;
            SmallTool.sleepMillis(timeSpend);
            SmallTool.printTimeAndThread("卡丁1号 过桥完毕 耗时:" + timeSpend);
            // 中断 two 线程的睡眠
            two.interrupt();
        });

        one.start();
        two.start();
    }
}
