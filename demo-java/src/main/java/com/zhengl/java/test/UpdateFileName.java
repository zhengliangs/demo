package com.zhengl.java.test;

import org.junit.Test;

import java.io.File;

public class UpdateFileName {

    /**
     * 批量修改文件名称
     */
    @Test
    public void t1() {
        File file = new File("D:\\captain\\Private Sphere\\新建文件夹\\黑袍纠察队\\第一季");
        File[] list = file.listFiles();
        // 如果目录下文件存在
        if (file.exists() && file.isDirectory()) {
            for (File file1 : list) {
                // 取文件名
                String fileName = file1.getName();
                String[] split = fileName.split("\\.");
                String level = split[2].substring(4, 6);
                String name = "The.Boys." + level + ".HD1080P.X264.AAC.mp4";
                // 重命名并存入指定目录
                File dest = new File("D:\\captain\\Private Sphere\\新建文件夹\\" + name);
                file1.renameTo(dest);
            }
        }
    }

}
