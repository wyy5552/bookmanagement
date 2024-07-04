package com.example.bookmanagement.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器配置
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        System.out.println("德玛西亚1Request processed in " );
        // 打印请求的参数
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            System.out.print(paramName + ": ");
            for (int i = 0; i < paramValues.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramValues[i]);
            }
            System.out.println();
        }

        System.out.println("request = " + request);
        // 继续执行下一个过滤器或目标资源
        chain.doFilter(request, response);
        // 打印返回体
        System.out.println("response = " + response);

        long endTime = System.currentTimeMillis();
        System.out.println("德玛西亚1Request processed in " + (endTime - startTime) + " ms");
    }

    @Override
    public void destroy() {
        // 销毁过滤器配置
    }
}
