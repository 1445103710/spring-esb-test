package com.yao.springbootwebsocket.controller;

/**
 * @className WebSocketController
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/09/15 20:05
 */

import com.yao.springbootwebsocket.cache.CacheList;
import com.yao.springbootwebsocket.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 */
@RestController
@RequestMapping("/api/ws")
public class WebSocketController {


    /**
     * 群发消息内容
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/sendAll", method = RequestMethod.POST)
    public String sendAllMessage(@RequestBody String message) {
        try {
            String s = "[" + LocalDateTime.now() + "]--";
            CacheList.setCache("["+s + message+"]");
            WebSocketServer.BroadCastInfo("["+s + message+"]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     * @param id      连接会话ID
     * @return
     */
    @RequestMapping(value = "/sendOne", method = RequestMethod.GET)
    public String sendOneMessage(@RequestParam(required = true) String message, @RequestParam(required = true) String id) {
        try {
            WebSocketServer.SendMessage(message, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     *
     * @return
     */
    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public String clenLog() {
        CacheList.clearCache();
        return "ok";
    }
}
