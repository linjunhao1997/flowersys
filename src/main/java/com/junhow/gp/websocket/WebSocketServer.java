package com.junhow.gp.websocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/4/8 17:38
 */
@ServerEndpoint("/echo/{role}")
@Component
public class WebSocketServer {
    private static Log log = LogFactory.getLog(WebSocketServer.class);
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSetForUser = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSetForAdmin = new CopyOnWriteArraySet<>();
    private Session session;

    public Session getSession() {
        return session;
    }

    public static CopyOnWriteArraySet<WebSocketServer> getWebSocketSetForAdmin() {
        return webSocketSetForAdmin;
    }

    public String role;
    @OnOpen
    public void onOpen(Session session, @PathParam("role") String role) {
        this.session = session;
        this.role = role;
        switch (role) {
            case "user":
                webSocketSetForUser.add(this);
                onlineCount.incrementAndGet();
                break;
            case "admin":
                webSocketSetForAdmin.add(this);
                break;
            default:
                break;
        }
        log.info("当前在线人数" + onlineCount.toString());
    }

    @OnClose
    public void onClose() {
        switch (this.role) {
            case "admin":
                webSocketSetForAdmin.remove(this);
                break;
            case "user":
                webSocketSetForUser.remove(this);
                onlineCount.decrementAndGet();
                log.info("当前在线人数" + onlineCount.toString());
                break;
            default:
                break;
        }

    }

    @OnMessage
    public void onMessage(String message, Session session) {

    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendOnlineCount() {
        try {
            this.session.getBasicRemote().sendText(onlineCount.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String str) {
        try {
            this.session.getBasicRemote().sendText(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
