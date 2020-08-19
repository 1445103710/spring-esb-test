package com.yao.netty;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className NIOFileChannel01
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/14 21:28
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello yaoyao";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/file01.txt");
        FileChannel channel = fileOutputStream.getChannel();
        //创建一个缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(str.getBytes());
        //对 byteBuffer 进行 flip
        allocate.flip();
        channel.write(allocate);
        fileOutputStream.close();
    }
}
