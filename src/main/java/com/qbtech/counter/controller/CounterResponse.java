package com.qbtech.counter.controller;

public class CounterResponse {

    private final boolean success;
    private final String message;

    public CounterResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
