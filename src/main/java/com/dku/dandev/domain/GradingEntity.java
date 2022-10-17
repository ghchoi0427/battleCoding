package com.dku.dandev.domain;

public class GradingEntity<T> {
    private final Object testResult;
    private String body;

    public GradingEntity(TestStatus testStatus) {
        this.testResult = testStatus;
    }

    public GradingEntity(TestStatus testStatus, String body) {
        this.testResult = testStatus;
        this.body = body;
    }

    public Object getTestResult() {
        return testResult;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
