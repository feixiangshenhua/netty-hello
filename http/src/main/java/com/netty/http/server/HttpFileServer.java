package com.netty.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * HTTP文件服务器
 * Created by xiaoyun on 2016/3/30.
 */
public class HttpFileServer {
    private static final String DEFAULT_URL = "/";

    public void run(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 将ByteBuf包装为HttpRequest
                            ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                            // 将多个消息转换为单一的FullHttpRequest或者FullHttpResponse
                            ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                            // 对http响应进行编码
                            ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                            // 支持异步发送大的码流，但不占用过多的内存，防止发生Java内存溢出
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture future = b.bind("127.0.0.1", port).sync();
            if(future.isSuccess()) {
                System.out.println("HTTP 文件目录服务器启动，网址是：http://127.0.0.1:" + port + url);
            }
            future.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 8080;
        new HttpFileServer().run(port, DEFAULT_URL);
    }
}
