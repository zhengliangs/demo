package com.zhengl.java.concurrent.thread;

/**
 * 演示线程的各个状态
 * @author hero良
 * @date 2022/9/6
 */
public class TestThreadState {

    static final Object LOCK = new Object();

    public static void main(String[] args) {
//        testNewRunnableTerminated();
//        testBlocked();
        testWaiting();
    }


    private static void testWaiting() {
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("before waiting"); // 1
                try {
                    LOCK.wait(); // 3
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t2.start();
        System.out.println("state: " + t2.getState()); // 2
        synchronized (LOCK) {
            System.out.println("state: " + t2.getState()); // 4
            LOCK.notify(); // 5
            System.out.println("state: " + t2.getState()); // 6
        }
        System.out.println("state: " + t2.getState()); // 7
    }

    private static void testBlocked() {
        Thread t2 = new Thread(() -> {
            System.out.println("before sync"); // 3
            synchronized (LOCK) {
                System.out.println("in sync"); // 4
            }
        },"t2");

        t2.start();
        System.out.println("state: " + t2.getState()); // 1
        synchronized (LOCK) {
            System.out.println("state: " + t2.getState()); // 2
        }
        System.out.println("state: "+t2.getState()); // 5
    }

    private static void testNewRunnableTerminated(){
        Thread t1 = new Thread(() -> {
            System.out.println("running...");
        });

        // NEW
        System.out.println(t1.getState());
        t1.start();
        // RUNNABLE
        System.out.println(t1.getState());

        // TERMINATED
        System.out.println(t1.getState());
    }
}
