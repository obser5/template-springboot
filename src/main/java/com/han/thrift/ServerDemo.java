package com.han.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * Thrift服务端demo
 *
 * @author hmj
 */
public class ServerDemo {
    public static final int SERVER_PORT = 8090;

    public static void startServer() {
        try {
            System.out.println("服务端已启动");
            TProcessor tprocessor = new ThriftService.Processor<ThriftService.Iface>(new ThriftServiceImpl());
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("服务端启动失败");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerDemo.startServer();
    }
}
