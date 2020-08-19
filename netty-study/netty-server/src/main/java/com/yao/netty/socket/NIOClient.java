package com.yao.netty.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @className NIOClient
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/16 10:28
 */
public class NIOClient {
    public static void main(String[] args) {
        try (
                SocketChannel socketChannel = SocketChannel.open();
        ) {
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            System.out.println("client 启动...");

            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            buffer.put("hi, 这是client".getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            socketChannel.write(buffer);

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                try {
                    socketChannel.write(ByteBuffer.wrap(s.getBytes())); }catch (IOException e) {
                    e.printStackTrace(); }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

