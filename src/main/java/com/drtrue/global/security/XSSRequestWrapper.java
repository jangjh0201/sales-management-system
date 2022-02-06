package com.drtrue.global.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.nhncorp.lucy.security.xss.XssPreventer;

/**
 * XSS 대응 XSSRequestWrapper
 * 
 * @author 이충욱
 * @since 1.0
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    private final String cleanBody;

    /**
     * request object wrapping 생성자
     * xss 대응 로직 작성
     * 
     * @param request
     */
    public XSSRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream inputStream = request.getInputStream();
        String dirty = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.joining("\n"));
        cleanBody = XssPreventer.escape(dirty)
                .replaceAll(";", "")
                .replace("&quot", "\"");
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                cleanBody.getBytes(StandardCharsets.UTF_8));
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}
