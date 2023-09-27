package com.zhengl.nio;

import java.nio.ByteBuffer;

import static com.zhengl.nio.ByteBufferUtil.debugAll;

public class TestByteBufferReadWrite {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        debugAll(buffer);
        // a
        buffer.put((byte) 0x61);
        debugAll(buffer);
        // b c d
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        debugAll(buffer);

        // 需要切换到读模式，不然什么都读不到，因为 position 的值没有变
        buffer.flip();
        debugAll(buffer);
        System.out.println("buffer.get() == " + buffer.get());
        debugAll(buffer);

        // 调用clear或者compact时候，并不会清空buffer的数据，但是position的位置会改变，然后将新写入的数据覆盖掉旧位置的数据
        buffer.clear();
        buffer.put((byte) 0x65);
        debugAll(buffer);

//        buffer.compact();
//        debugAll(buffer);
//        buffer.put((byte) 0x66);
    }
}
