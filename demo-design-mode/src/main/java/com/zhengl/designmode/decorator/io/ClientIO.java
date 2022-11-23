package com.zhengl.designmode.decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hero良
 */
public class ClientIO {

    public static void main(String[] args) {
        int c;
        try (InputStream is = new LowerCaseInputStream(
                new BufferedInputStream(new FileInputStream("D:\\Users\\Administrator\\Desktop\\io.txt")))) {
            while((c = is.read()) >= 0){
                System.out.print((char)c);
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
