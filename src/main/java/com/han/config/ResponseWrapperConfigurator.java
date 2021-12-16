package com.han.config;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * websocket自定义配置类
 *
 * @author hmj
 * @since 2021/12/16
 */

public class ResponseWrapperConfigurator extends Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        response.getHeaders().put("Sec-WebSocket-Protocol", request.getHeaders().get("Sec-WebSocket-Protocol"));
    }
}
