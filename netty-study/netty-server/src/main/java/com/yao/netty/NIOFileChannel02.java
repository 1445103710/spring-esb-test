package com.yao.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className NIOFileChannel02
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/14 21:36
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate((int) file.length());
        channel.read(allocate);

        System.out.println(new String(allocate.array()));
        fileInputStream.close();
    }
}
