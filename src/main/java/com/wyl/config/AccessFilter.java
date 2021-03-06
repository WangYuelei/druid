package com.wyl.config;

import com.alibaba.druid.util.StringUtils;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //如果是POST走自己的继承的HttpServletRequestWrapper类请求，否则走正常的请求
        if(StringUtils.equalsIgnoreCase(HttpMethod.POST.name(), request.getMethod())){
            //一定要在判断中new对象，否则还会出现Stream closed问题
            filterChain.doFilter(new AccessRequestWrapper(request),servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}