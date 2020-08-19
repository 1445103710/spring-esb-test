package com.yao.netty;

import java.nio.ByteBuffer;

/**
 * @className ReadOnlyBuffer
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/16 08:52
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            allocate.put((byte) i);

        }
        allocate.flip();
        ByteBuffer byteBuffer = allocate.asReadOnlyBuffer();

        System.out.println(byteBuffer.getClass());

        while (byteBuffer.hasRemaining()) {

            System.out.println(byteBuffer.get());
        }
        byteBuffer.put((byte)12);
    }
}
