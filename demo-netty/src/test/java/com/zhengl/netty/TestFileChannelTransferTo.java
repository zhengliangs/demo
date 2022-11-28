package com.zhengl.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannelTransferTo {

    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("D:\\captain\\Private Sphere\\新建文件夹\\2333\\杀死比尔.1080p.BD中英双字[66影视www.66Ys.Co].mp4").getChannel();
             FileChannel to = new FileOutputStream("D:\\captain\\Private Sphere\\新建文件夹\\2333\\杀死比尔1.1080p.BD中英双字[66影视www.66Ys.Co].mp4").getChannel()
        ) {
            // 效率高，会利用操作系统的零拷贝进行优化，最多传输2g
//            from.transferTo(0, from.size(), to);
            // 要读取的文件大小
            long size = from.size();
            System.out.println("size = " + size);

            for (long left = size ; left > 0;) {
                left -= from.transferTo((size - left), from.size(), to);
                System.out.println("position = " + (size - left) + " left = " + left);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
