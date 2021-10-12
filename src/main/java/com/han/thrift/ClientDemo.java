package com.han.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;


/**
 * Thrift客户端Demo
 *
 * @author hmj
 */
public class ClientDemo {

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    public static void startClient(String temp) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftService.Client client = new ThriftService.Client(protocol);
            transport.open();
            client.getMsg(temp);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        String temp = "aaa";
        System.out.println("执行服务端方法getMsg()，传递参数为：" + temp);
        ClientDemo.startClient(temp);
    }
}
