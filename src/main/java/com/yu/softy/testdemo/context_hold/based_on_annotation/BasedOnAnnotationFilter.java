package com.yu.softy.testdemo.context_hold.based_on_annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 * @Description: 过滤器，顾名思义，能够过滤一切请求（而拦截器只能过滤action请求），包括静态资源的请求。
 *                 chain.doFilter(request, response)表示过滤通过，能够往下执行。
 *                 所以过滤操作要写在chain.doFilter(request, response) 前面，作一些条件判断；
 *                 如果不符合条件，则不执行chain.doFilter(request, response);
 *
 * @Order 定义优先级
 * Application 添加 @ServletComponentScan springboot启动类扫描servlet组件(过滤器)
 */
@Order(1)
@WebFilter(filterName="BasedOnAnnotationFilter",urlPatterns="/*")
@Slf4j
public class BasedOnAnnotationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("BasedOnAnnotationFilter ==> init method: init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("BasedOnAnnotationFilter ==> doFilter method: before");
        chain.doFilter(request, response);
        log.info("BasedOnAnnotationFilter ==> doFilter method: after");
    }

    @Override
    public void destroy() {
        log.info("BasedOnAnnotationFilter ==> destroy method: destroy");
    }
}
