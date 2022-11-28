package com.zhengl.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 批量写入，channel 的 write 支持传入 ByteBuffer 数组
 * @author hero良
 * @date 2022/11/24
 */
public class TestScatteringWrites {

    public static void main(String[] args) {
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer buffer3 = StandardCharsets.UTF_8.encode("你好！！！");

        try (FileChannel channel = new RandomAccessFile("D:\\study\\code\\demo\\demo-netty\\work1.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{buffer1, buffer2, buffer3});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
