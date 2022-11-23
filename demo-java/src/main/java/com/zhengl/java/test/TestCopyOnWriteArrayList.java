package com.zhengl.java.test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("");
    }
}
