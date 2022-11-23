package com.zhengl.netty;

import java.nio.ByteBuffer;

import static com.zhengl.netty.ByteBufferUtil.debugAll;

/**
 * ByteBuffer的读
 */
public class TestByteBufferRead {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b','c', '4'});
        buffer.flip();

        // 正常的读
//        buffer.get(new byte[4]);
//        debugAll(buffer);

        // rewind 从头开始读
//        buffer.rewind();
//        System.out.println("buffer.get == " + (char) buffer.get());
//        debugAll(buffer);

        // mark & reset
        // mark 做一个标记，记录 position 的位置，reset 是将 position 重置到 mark 的位置
//        System.out.println("buffer.get == " + (char) buffer.get());
//        System.out.println("buffer.get == " + (char) buffer.get());
//        buffer.mark();
//        debugAll(buffer);
//        System.out.println("buffer.get == " + (char) buffer.get());
//        System.out.println("buffer.get == " + (char) buffer.get());
//        debugAll(buffer);
//        buffer.reset();
//        debugAll(buffer);
//        System.out.println("buffer.get == " + (char) buffer.get());
//        System.out.println("buffer.get == " + (char) buffer.get());

        // get(i) 读不会修改 position 的位置
        System.out.println("buffer.get == " + (char) buffer.get(3));
        debugAll(buffer);
    }
}
