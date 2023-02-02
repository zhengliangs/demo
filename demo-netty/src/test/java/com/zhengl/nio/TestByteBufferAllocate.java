package com.zhengl.nio;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {

    public static void main(String[] args) {
        // class java.nio.HeapByteBuffer
        System.out.println(ByteBuffer.allocate(16).getClass());

        //class java.nio.DirectByteBuffer
        System.out.println(ByteBuffer.allocateDirect(16).getClass());

        /*
             allocate: java堆内存，读写效率低，会受到 GC 的影响
             allocateDirect: 直接内存，读写效率高（少一次拷贝），不会受到 GC 影响，但是分配效率低
         */
    }
}
