/*
 * Copyright (c) 2018, org.smartboot. All rights reserved.
 * project name: smart-socket
 * file name: HttpV2Entity.java
 * Date: 2018-01-23
 * Author: sandao
 */

package org.smartboot.socket.http;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.math.NumberUtils;
import org.smartboot.socket.http.strategy.PostDecodeStrategy;
import org.smartboot.socket.transport.AioSession;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 三刀 on 2017/6/20.
 */
public class HttpV2Entity {

    public static final String AUTHORIZATION = "Authorization";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_MD5 = "Content-MD5";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String DATE = "Date";
    public static final String ETAG = "ETag";
    public static final String EXPIRES = "Expires";
    public static final String HOST = "Host";
    public static final String LAST_MODIFIED = "Last-Modified";
    public static final String RANGE = "Range";
    public static final String LOCATION = "Location";
    public static final String CONNECTION = "Connection";
    PostDecodeStrategy postDecodeStrategy;
    private InputStream inputStream = null;
    private int contentLength = -1;
    private String method, url, protocol, contentType, decodeError;
    private Map<String, String> headMap = new HashMap<String, String>();
    private Map<String, String> paramMap = new HashMap<String, String>();

    public HttpV2Entity(AioSession<HttpV2Entity> session) {
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setHeader(String name, String value) {
        headMap.put(name, value);
        if (StringUtils.equals(name, CONTENT_LENGTH)) {
            contentLength = NumberUtils.toInt(value, -1);
        }
    }

    public String getHeader(String key) {
        return headMap.get(key);
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDecodeError() {
        return decodeError;
    }

    public void setDecodeError(String decodeError) {
        this.decodeError = decodeError;
    }

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

}
