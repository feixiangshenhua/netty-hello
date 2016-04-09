package com.netty.server;

import com.netty.serializable.po.SubScribeReq;
import com.netty.serializable.po.SubscribeResp;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 请求处理机
 * Created by xiaoyun on 2016/3/24.
 */
@ChannelHandler.Sharable
public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubScribeReq req = (SubScribeReq)msg;
        if("xiaoyun".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Service accept client subscribe req：["
            + req.toString()+"]");
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }else {
            System.out.println("error req.");
        }
    }

    private SubscribeResp resp(int subReqID) {
        SubscribeResp resp = new SubscribeResp();
        resp.setSubReqID(subReqID);
        resp.setRespCode(0);
        resp.setDesc("Netty book order succeed, 3 days later, send to the designated address");
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close(); // 发生异常，关闭链路
    }
}
