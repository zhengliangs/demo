package com.zhengl.netty;

import java.nio.ByteBuffer;

import static com.zhengl.netty.ByteBufferUtil.debugAll;

public class TestByteBufferExam {

    public static void main(String[] args) {
        /*
            Hello,World\n
            I'm zhangsan\n
            How are you?\n

            粘包：客户端发送了5次数据，而服务端一次性全部读取过来了
            半包：客户端发送了1次数据，而服务端分多次读到

            变成了下面的两个 ByteBuffer(粘包，半包)
            Hello,World\nI'm zhangsan\nHo
            w are you?\n
         */

        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you？\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source) {
        // 切换至读模式
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            // 找到了一条完整的数据
            if (source.get(i) == '\n') {
                // 这里需要 - source.position() 也就是已经读过的数据
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从 source 读，向 target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(source);
//                debugAll(target);
            }
        }
        // 切换至写模式
        source.compact();
    }
}
