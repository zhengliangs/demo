package com.zhengl.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {

    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("D:\\study\\code\\demo\\demo-netty\\data.txt").getChannel()) {
            // 准备缓存区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 从 channel 读取数据，向 buffer 写入数据
                int len = channel.read(buffer);
                log.debug("读到的字节数 = {}", len);
                // -1 表示数据读完了
                if (len == -1){
                    break;
                }
                // flip 切换至读模式
                buffer.flip();
                // buffer.hasRemaining() 是否还有剩余未读数据
                while (buffer.hasRemaining()) {
                    // 从 buffer 读数据
                    byte b = buffer.get();
                    // 打印 buffer 内容
                    log.debug("实际字节 = {}", (char) b);
                }
                // clear 切换至写模式
//                buffer.clear();
                // 切换至写模式，会压缩没有读完的数据，再次写入的时候不会覆盖掉未读的数据
                buffer.compact();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
