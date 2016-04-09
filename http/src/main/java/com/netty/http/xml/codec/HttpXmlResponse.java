package com.netty.http.xml.codec;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 响应信息协议栈
 * Created by xiaoyun on 2016/4/4.
 */
public class HttpXmlResponse {
    private FullHttpResponse httpResponse;
    private Object result;

    public HttpXmlResponse(FullHttpResponse httpResponse, Object result) {
        this.httpResponse = httpResponse;
        this.result = result;
    }

    /**
     * @return the httpResponse
     */
    public final FullHttpResponse getHttpResponse() {
        return httpResponse;
    }

    /**
     * @param httpResponse
     *            the httpResponse to set
     */
    public final void setHttpResponse(FullHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    /**
     * @return the result
     */
    public final Object getResult() {
        return result;
    }

    /**
     * @param result
     *            the body to set
     */
    public final void setResult(Object result) {
        this.result = result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HttpXmlResponse [httpResponse=" + httpResponse + ", result="
                + result + "]";
    }
}
