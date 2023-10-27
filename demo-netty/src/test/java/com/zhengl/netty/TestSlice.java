package com.zhengl.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import static com.zhengl.netty.TestByteBuf.log;

public class TestSlice {

    public static void main(String[] args) {

        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        buf.writeBytes(new byte[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'});
        log(buf);

        // 切片后的 ByteBuf 是不可以添加元素的
        ByteBuf b1 = buf.slice(0, 5);
        log(b1);
        ByteBuf b2 = buf.slice(5, 5);
        log(b2);

    }
}
