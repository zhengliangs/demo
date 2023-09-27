package com.zhengl.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.zhengl.nio.ByteBufferUtil.debugRead;

/*
    非阻塞模式下，accept 和 read 不需要等待有客户端连接和发送数据，程序会一直执行，会出现cpu的浪费
 */

@Slf4j
public class ServerNonBlock {

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // 1. 创建服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 默认是true，也就是阻塞模式，false是非阻塞模式
        ssc.configureBlocking(false);
        // 2. 绑定监听端口
        ssc.bind(new InetSocketAddress(8689));
        // 3. 连接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 4. accept 建立与客户端的连接，SocketChannel 用来与客户端之间通信
            // accept 非阻塞，线程还会继续运行，如果没有连接，sc 会是 null
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                log.debug("connected...{}", sc);
                // 非阻塞模式
                sc.configureBlocking(false);
                channels.add(sc);
            }
            for (SocketChannel channel : channels) {
                // 5. 接收客户端发送的数据
                // 非阻塞，线程还会运行，如果没有读到数据，read 会返回 0
                int read = channel.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    debugRead(buffer);
                    buffer.clear();
                    log.debug("after read...{}", channel);
                }
            }
        }
    }
}
