package com.zhengl.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(8688));
        sc.write(Charset.defaultCharset().encode("123456789\n"));
        System.in.read();
    }
}
