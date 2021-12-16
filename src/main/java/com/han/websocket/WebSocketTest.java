package com.han.websocket;

import com.alibaba.fastjson.JSONObject;
import com.han.config.ResponseWrapperConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket接口，添加了自定义配置类，用来对请求和响应进行包装
 *
 * @author hmj
 * @since 2021/12/16
 */


@Component
@ServerEndpoint(value = "/websocket/{guid}", configurator = ResponseWrapperConfigurator.class)
public class WebSocketTest {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketTest.class);
    private static ConcurrentHashMap<String, WebSocketTest> userSocketSet = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        String uri = session.getRequestURI().toString();
        String guid = uri.substring(uri.lastIndexOf("/") + 1);
        if (!userSocketSet.containsKey(guid)) {
            userSocketSet.put(guid, this);
            logger.info("websocket链接已建立，guid为：" + guid);
        }
    }

    @OnClose
    public void onClose(@PathParam("guid") String guid) {
        if (userSocketSet.containsKey(guid)) {
            userSocketSet.remove(guid);
            logger.info("websocket链接已断开，guid为：" + guid);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自客户端的信息：" + message);
    }

    @OnError
    public void onError(Throwable e) {
        logger.error("webSocket链接异常", e);
    }


    /**
     * 向所有用户广播消息
     *
     * @param jsonObject
     */
    public static void sendAllUserData(JSONObject jsonObject) {
        for (WebSocketTest webSocketTest : userSocketSet.values()) {
            synchronized ((webSocketTest)) {
                try {
                    webSocketTest.sendMessage(jsonObject);
                } catch (IOException e) {
                    logger.error("webSocket推送异常", e);
                }
            }
        }
    }

    public void sendMessage(JSONObject jsonObject) throws IOException {
        String uri = session.getRequestURI().toString();
        String guid = uri.substring(uri.lastIndexOf("/") + 1);
        synchronized (session) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(jsonObject.toString());
                logger.info("websocket推送，guid:" + guid + "，数据：" + jsonObject);
            }
        }
    }
}
