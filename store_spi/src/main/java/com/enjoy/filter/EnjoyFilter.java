package com.enjoy.filter;

import com.alibaba.dubbo.rpc.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class EnjoyFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Map<String,String> rpc_ip = new HashMap<>();

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            rpc_ip.put("rpc_ip",ip);
            RpcContext.getContext().setAttachments(rpc_ip);
            System.out.println("add rpc_id:"+ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return invoker.invoke(invocation);
    }
}
