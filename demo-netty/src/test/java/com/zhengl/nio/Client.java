package com.zhengl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client {

    public static void main(String[] args) throws IOException {
//        SocketChannel sc = SocketChannel.open();
//        sc.connect(new InetSocketAddress(8688));
//        System.out.println("waiting...");

        // 非阻塞
//        SocketChannel sc = SocketChannel.open();
//        sc.connect(new InetSocketAddress("localhost",8689));
//        System.out.println("waiting...");

        // selector
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8690));
        sc.write(Charset.defaultCharset().encode("hello\nworld\n166661698是\n大V我上个\n"));
        System.in.read();
    }
}
