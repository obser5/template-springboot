package com.han.thrift;

import com.han.thrift.ThriftService;
import org.apache.thrift.TException;

/**
 *
 *
 * @author hmj
 * @since 2021/10/11
 */
public class ThriftServiceImpl implements ThriftService.Iface {
    @Override
    public void ping() throws TException {

    }

    @Override
    public String getMsg(String temp) throws TException {
        System.out.println("收到客户端数据：" + temp);
        return temp;
    }

    @Override
    public String sendMsg(String temp) throws TException {
        return temp;
    }
}
