package com.netty.http.xml.codec;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * http+xml请求消息
 * Created by xiaoyun on 2016/4/4.
 */
public class HttpXmlRequest {

    private FullHttpRequest request;

    private Object body;

    public HttpXmlRequest(FullHttpRequest request, Object body) {
        this.request = request;
        this.body = body;
    }

    public final Object getBody() {
        return body;
    }

    public final void setBody(Object body) {
        this.body = body;
    }

    public final FullHttpRequest getRequest() {
        return request;
    }

    public final void setRequest(FullHttpRequest request) {
        this.request = request;
    }
}
