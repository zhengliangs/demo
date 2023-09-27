package com.zhengl.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.zhengl.nio.ByteBufferUtil.debugAll;

@Slf4j
public class TestByteBufferExam {

    public static void main(String[] args) {
        /*
            Hello,World\n
            I'm zhangsan\n
            How are you?\n

            变成了下面的两个 ByteBuffer(粘包，半包)
            Hello,World\nI'm zhangsan\nHo
            w are you?\n

            编写程序，将错乱的数据恢复成原始按 \n 分割的数据

            粘包：客户端发送了5次数据，而服务端一次性全部读取过来了
            半包：客户端发送了1次数据，而服务端分多次读到
         */

        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you？\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source) {
        // 切到读模式
        source.flip();
        int limit = source.limit();
        for (int i = 0; i < limit; i++) {
            // 找到了一条完整的数据
            // get(i)不会改变position的值
            if (source.get(i) == '\n') {
                // 这里需要 - source.position() 也就是已经读过的数据
                int length = i + 1 - source.position();
                System.out.println(length);
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    // get()会改变position的值
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        // 切换至写模式
        source.compact();
    }
}
