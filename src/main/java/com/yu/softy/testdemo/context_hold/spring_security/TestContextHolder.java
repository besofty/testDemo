package com.yu.softy.testdemo.context_hold.spring_security;

public class TestContextHolder {

    private static TestContextHolderStrategy strategy = new TestContextHolderStrategy();

    public static void clearContext() {
        strategy.clearContext();
    }

    public static TestContext getContext() {
        return strategy.getContext();
    }

    public static void setContext(TestContext context) {
        strategy.setContext(context);
    }

    public static TestContext createEmptyContext() {
        return strategy.createEmptyContext();
    }
}
