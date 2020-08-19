package com.yao.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className MappedByteBufferTest
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/16 09:02
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/file01.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        /**
        * 参数 1: FileChannel.MapMode.READ_WRITE 使用的读写模式
        * 参数 2: 0 : 可以直接修改的起始位置
        * 参数 3: 5: 是映射到内存的大小(不是索引位置) ,即将 1.txt 的多少个字节映射到内存 * 可以直接修改的范围就是 0-5
        * 实际类型 DirectByteBuffer
        */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(1, (byte) 'H');
        mappedByteBuffer.put(2, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');
        mappedByteBuffer.put(4, (byte) '9');
//        mappedByteBuffer.put(5, (byte) 'Y');//IndexOutOfBoundsException

        randomAccessFile.close();
        while (mappedByteBuffer.hasRemaining()){
            System.out.println(mappedByteBuffer.get());
        }
        System.out.println("修改成功~~");

    }
}
