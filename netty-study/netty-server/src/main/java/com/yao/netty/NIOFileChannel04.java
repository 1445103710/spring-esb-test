package com.yao.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @className NIOFileChannel04
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/16 08:32
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/1122.mp4");
        FileChannel channel1 = fileInputStream1.getChannel();
        FileOutputStream fileOutputStream2 = new FileOutputStream("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/2211.mp4");
        FileChannel channel2 = fileOutputStream2.getChannel();

        channel2.transferFrom(channel1,0,channel2.size());

        channel1.close();
        channel2.close();
        fileInputStream1.close();
        fileOutputStream2.close();
    }
}
