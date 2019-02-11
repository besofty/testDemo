package com.yu.softy.testdemo.context_hold.spring_security;

import org.springframework.util.Assert;

public class TestContextHolderStrategy {
    private static final InheritableThreadLocal<TestContext> contextHolder = new InheritableThreadLocal();

    public void clearContext() {
        contextHolder.remove();
    }

    public TestContext getContext() {
        TestContext ctx = contextHolder.get();
        if (ctx == null) {
            ctx = this.createEmptyContext();
            contextHolder.set(ctx);
        }

        return ctx;
    }

    public void setContext(TestContext context) {
        Assert.notNull(context, "Only non-null SecurityContext instances are permitted");
        contextHolder.set(context);
    }

    public TestContext createEmptyContext() {
        return new TestContext();
    }
}
