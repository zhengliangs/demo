package com.zhengl.nio;

import java.nio.ByteBuffer;

import static com.zhengl.nio.ByteBufferUtil.debugAll;

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

        // rewind 从头开始读/反复读
//        buffer.rewind();
//        System.out.println("buffer.get == " + (char) buffer.get());
//        debugAll(buffer);

        // mark & reset
        // 反复读指定的数据
        // mark 做一个标记，记录 position 的位置，reset 是将 position 重置到 mark 的位置
        System.out.println("buffer.get == " + (char) buffer.get());
        System.out.println("buffer.get == " + (char) buffer.get());
        // 加标记，索引2的位置
        buffer.mark();
        debugAll(buffer);
        System.out.println("buffer.get == " + (char) buffer.get());
        System.out.println("buffer.get == " + (char) buffer.get());
        debugAll(buffer);
        // 将position重置到索引2
        buffer.reset();
        debugAll(buffer);
        System.out.println("buffer.get == " + (char) buffer.get());
        System.out.println("buffer.get == " + (char) buffer.get());

        // get(i) 读不会修改 position 的位置
        System.out.println("buffer.get == " + (char) buffer.get(3));
        debugAll(buffer);
    }
}
