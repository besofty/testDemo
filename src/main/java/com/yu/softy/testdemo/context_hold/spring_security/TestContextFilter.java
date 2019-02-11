package com.yu.softy.testdemo.context_hold.spring_security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * EnableWebSecurity 来继承 WebSecurityConfigurerAdapter
 */
@Slf4j
public class TestContextFilter extends GenericFilterBean {
    private static final String CONTEXT = "test_context";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        TestContext testContext = new TestContext()
                .setContext(((HttpServletRequest) request).getHeader(CONTEXT));
        TestContextHolder.getContext().setContext(testContext.getContext());
        filterChain.doFilter(request, response);
    }
}
