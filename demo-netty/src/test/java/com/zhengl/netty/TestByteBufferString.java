package com.zhengl.netty;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.zhengl.netty.ByteBufferUtil.debugAll;

public class TestByteBufferString {

    public static void main(String[] args) {
        // 1. 字符串转为 ByteBuffer
        // getBytes 不会自动切换到读模式，而 Charset 和 wrap 都会切换到读模式

        // 利用字符串的 getBytes() 方法
        ByteBuffer buffer1 = ByteBuffer.allocate(16);
        buffer1.put("hellowrold".getBytes());
        debugAll(buffer1);

        // CharSet
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("helloworld");
        debugAll(buffer2);

        // wrap
        ByteBuffer buffer3 = ByteBuffer.wrap("helloworld".getBytes());
        debugAll(buffer3);


        // 2. ByteBuffer 转为字符串

        // Charset
        String str1 = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println("str1 == " + str1);

        // 需要切换到读模式
        buffer1.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer1).toString();
        System.out.println("str2 == " + str2);
    }
}
