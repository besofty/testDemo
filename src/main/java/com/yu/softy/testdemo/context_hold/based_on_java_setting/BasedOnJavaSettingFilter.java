package com.yu.softy.testdemo.context_hold.based_on_java_setting;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class BasedOnJavaSettingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("BasedOnJavaSettingFilter ==> init method: init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("BasedOnJavaSettingFilter ==> doFilter method: before");
        chain.doFilter(request, response);
        log.info("BasedOnJavaSettingFilter ==> doFilter method: after");
    }

    @Override
    public void destroy() {
        log.info("BasedOnJavaSettingFilter ==> destroy method: destroy");
    }
}
