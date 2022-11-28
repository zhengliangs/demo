package com.zhengl.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.zhengl.netty.ByteBufferUtil.debugAll;

/**
 * 批量读取，channel 的 read 方法支持读取 ByteBuffer 数组
 * @author hero良
 * @date 2022/11/24
 */
public class TestScatteringReads {

    public static void main(String[] args) {
        try (FileChannel channel = new RandomAccessFile("D:\\study\\code\\demo\\demo-netty\\work.txt", "r").getChannel()) {
            ByteBuffer buffer1 = ByteBuffer.allocate(3);
            ByteBuffer buffer2 = ByteBuffer.allocate(3);
            ByteBuffer buffer3 = ByteBuffer.allocate(5);

            // 批量读取
            channel.read(new ByteBuffer[]{buffer1, buffer2, buffer3});

            debugAll(buffer1);
            debugAll(buffer2);
            debugAll(buffer3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
