package com.wyl.config;

import com.alibaba.druid.util.StringUtils;
import com.wyl.utils.NetworkUtil;
import com.wyl.utils.RequestUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器：拦截请求目的是将请求的信息收集到日志
 */
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        //客户端类型
        String clientType = userAgent.getOperatingSystem().getDeviceType().getName();
        //客户端操作系统类型
        String osType = userAgent.getOperatingSystem().getName();
        //客户端ip
//        String clientIp = request.getRemoteAddr();
        String clientIp = NetworkUtil.getIpAddress(request);
        //客户端port
        int clientPort = request.getRemotePort();
        //请求方式
        String requestMethod = request.getMethod();
        //客户端请求URI
        String requestURI = request.getRequestURI();
        //客户端请求参数值
        String requestParam;
        //如果请求是POST获取body字符串，否则GET的话用request.getQueryString()获取参数值
        if(StringUtils.equalsIgnoreCase(HttpMethod.POST.name(), requestMethod)){
            requestParam = RequestUtil.getBodyString(request);
        }else{
            requestParam = request.getQueryString();
        }
        //客户端整体请求信息
        StringBuilder clientInfo = new StringBuilder();
        clientInfo.append("客户端信息:[类型:").append(clientType)
                .append(", 操作系统类型:").append(osType)
                .append(", ip:").append(clientIp)
                .append(", port:").append(clientPort)
                .append(", 请求方式:").append(requestMethod)
                .append(", URI:").append(requestURI)
                .append(", 请求参数值:").append(requestParam=requestParam==null?null:requestParam.replaceAll("\\s*", ""))
                .append("]");

        //***这里的clientInfo就是所有信息了，请根据自己的日志框架进行收集***
        System.out.println(clientInfo);

        //返回ture才会继续执行，否则一直拦截住
        return true;
    }
}
