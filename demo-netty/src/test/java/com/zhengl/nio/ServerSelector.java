package com.zhengl.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

import static com.zhengl.nio.ByteBufferUtil.debugAll;

/*
    疑问1: key.attachment(); 得到的 ByteBuffer 中的数据是什么时候写入的?
 */
@Slf4j
public class ServerSelector {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8688));
        ssc.configureBlocking(false);

        // 1. 创建 Selector , 用来管理 Channel
        Selector selector = Selector.open();

        // 2. 建立 selector 和 channel 的联系, 将 channel 注册到 selector 上
        // selectionKey 就是将来事件发生后，通过它可以知道事件和哪个 Channel 的事件
        SelectionKey sscKey = ssc.register(selector, 0,  null);
        // key 只关注 accept 事件
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        log.debug("register key == {}", sscKey);

        while (true) {
            // 3. select 方法，没有事件发生的时候，线程阻塞，有事件发生，线程才会恢复运行
            // select 在事件没有处理的时候，它不会阻塞，事件发生后要么处理，要么取消，不能置之不理
            int count = selector.select();
            log.info("count = {}", count);
            // 4. 处理事件, selectorKeys 内部包含了所有发生的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                // 处理 key 的时候，要从 selectionKeys 集合中删除掉，否则下次处理的时候就会有问题
                it.remove();
                log.debug("key == {}", key);
                // 5. 区分事件类型
                if (key.isAcceptable()) { // accept 事件
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);

                    log.debug("sc == {}", sc);
                    ByteBuffer buffer = ByteBuffer.allocate(16);
                    // 将 ByteBuffer 作为附件关联到 selectionKey 上
                    SelectionKey scKey = sc.register(selector, 0, buffer);
                    scKey.interestOps(SelectionKey.OP_READ);

                    log.debug("scKey == {}", scKey);
                } else if (key.isReadable()) { // read 事件
                    try {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        int read = channel.read(buffer);
                        if (read == -1) {
                            log.debug("channel 正常断开...");
                            // 如果是正常断开，read 方法返回的返回值是-1
                            key.cancel();
                        } else {
                            split(buffer);
                            if (buffer.position() == buffer.limit()) {
                                ByteBuffer newBuffer = ByteBuffer.allocate(buffer.capacity() * 2);
                                buffer.flip();
                                newBuffer.put(buffer);
                                key.attach(newBuffer);
                            }
                        }
                    }catch (IOException e) {
                        log.debug("channel 异常断开...");
                        e.printStackTrace();
                        // 因为客户端断开了，需要将 key 取消(从 selector 的 keys 集合中真正删除)
                        key.cancel();
                    }
                }
                // 取消事件
//                key.cancel();
            }
        }
    }

    private static void split(ByteBuffer source) {
        // 切换至读模式
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            // 找到了一条完整的数据
            if (source.get(i) == '\n') {
                // 这里需要 - source.position() 也就是已经读过的数据
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从 source 读，向 target 写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
//                debugAll(source);
                debugAll(target);
            }
        }
        // 切换至写模式
        source.compact();
    }
}
