package com.qbtech.counter.controller;

public class CounterValueResponse {

    private final int value;
    private final String message;

    public CounterValueResponse(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
