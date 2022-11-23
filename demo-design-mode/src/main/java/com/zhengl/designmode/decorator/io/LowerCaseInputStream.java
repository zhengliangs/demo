package com.zhengl.designmode.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FilterInputStream 是装饰者的基类
 * @author hero良
 */
public class LowerCaseInputStream extends FilterInputStream{

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = super.read();
        return (read == -1 ? read : Character.toLowerCase((char) read));
    }
}
