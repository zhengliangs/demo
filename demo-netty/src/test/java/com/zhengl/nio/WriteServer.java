package com.zhengl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class WriteServer {

    public static void main(String[] args) throws IOException {
        // 1.创建ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 8080));
        ssc.configureBlocking(false);

        // 2.创建selector管理ServerSocketChannel
        Selector selector = Selector.open();
        // 只接受连接事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        
        while (true) {
            // 线程会阻塞，收到事件的时候才会运行
            selector.select();

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            if (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                it.remove();
                // 连接事件
                if (selectionKey.isAcceptable()) {
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    SelectionKey scKey = sc.register(selector, 0, null);

                    StringBuilder sb = new StringBuilder();
                    // 3.发送数据
                    for (int i = 0; i < 30000000; i++) {
                        sb.append("a");
                    }
                    ByteBuffer buffer = Charset.defaultCharset().encode(sb.toString());
                    // 返回实际写入的字节数
                    int write = sc.write(buffer);
                    System.out.println("write = " + write);
                    // 是否还有元素没写完
                    if (buffer.hasRemaining()) {
                        // 关注可写事件
                        scKey.interestOps(scKey.interestOps() + SelectionKey.OP_WRITE);
//                        scKey.interestOps(scKey.interestOps() | SelectionKey.OP_WRITE);
                        // 把未写完的数据挂到scKey上
                        scKey.attach(buffer);
                    }
                } else if (selectionKey.isWritable()) {
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    int write = sc.write(buffer);
                    System.out.println("2 write = " + write);
                    // 清理buffer
                    if (!buffer.hasRemaining()) {
                        selectionKey.attach(null);
                        // 取消关注可写事件
                        selectionKey.interestOps(selectionKey.interestOps() - SelectionKey.OP_WRITE);
                    }
                }
            }
        }
    }
}
