package com.example.bookmanagement.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Logging2Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器配置
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        System.out.println("德玛西亚2Request processed in ");
        // 继续执行下一个过滤器或目标资源
        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        System.out.println("德玛西亚2Request processed in " + (endTime - startTime) + " ms");
    }

    @Override
    public void destroy() {
        // 销毁过滤器配置
    }
}
