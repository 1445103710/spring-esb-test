package com.yao.netty;

import java.nio.IntBuffer;

/**
 * @className BasicBuffer
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/15 12:57
 */
public class BasicBuffer {

    public static void main(String[] args) {


        IntBuffer buffer = IntBuffer.allocate(5);
//        buffer.put(10);
//        buffer.put(11);
//        buffer.put(12);
//        buffer.put(13);
//        buffer.put(14);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i*2);
        }

        buffer.flip();

        while (buffer.hasRemaining()){
            System.out.println(buffer.get());

        }
        
    }
    
    
}
