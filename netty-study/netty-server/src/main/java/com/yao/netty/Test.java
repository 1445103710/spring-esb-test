package com.yao.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;

import java.time.LocalDateTime;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/06/13 22:29
 */
public class Test {

    private static final int port = 8080;

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup,workerGroup).channel(NioSctpServerChannel.class);

        server.bind(port).addListener(future -> {
            if(future.isSuccess()) {
                System.out.println(LocalDateTime.now() + ": 端口["+ port + "]绑定成功!");
            } else{
                System.err.println("端口["+ port + "]绑定失败!");
            }
        });
    }
}
