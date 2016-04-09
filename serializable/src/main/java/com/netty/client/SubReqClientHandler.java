package com.netty.client;

import com.netty.serializable.po.SubScribeReq;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端处理机
 * Created by xiaoyun on 2016/3/24.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i <10 ; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubScribeReq subReq(int i) {
        SubScribeReq req = new SubScribeReq();
        req.setAddress("山东省菏泽市牡丹区段庄");
        req.setPhoneNumber("186xxxxxxxx");
        req.setProductName("Netty 权威指南");
        req.setSubReqID(i);
        req.setUserName("xiaoyun");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response ：[" + msg +"]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
