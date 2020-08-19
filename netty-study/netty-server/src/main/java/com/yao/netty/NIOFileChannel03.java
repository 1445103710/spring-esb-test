package com.yao.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className NIOFileChannel03
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/16 08:19
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream1 = new FileInputStream("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/file01.txt");
        FileChannel channel1 = fileInputStream1.getChannel();
        FileOutputStream fileOutputStream2 = new FileOutputStream("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/file02.txt");
        FileChannel channel2 = fileOutputStream2.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {

            //这里有一个重要的操作，一定不要忘了
            /*
            public final Buffer clear() {
                position = 0;
                limit = capacity;
                 mark = -1;
                 return this;
            } */

            byteBuffer.clear();
            int read = channel1.read(byteBuffer);
            System.out.println("read:"+read);
            if (read==-1){
                break;
            }
            byteBuffer.flip();
            channel2.write(byteBuffer);
        }


        //关闭流
        fileInputStream1.close();
        fileOutputStream2.close();
    }
}
