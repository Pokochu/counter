package com.qbtech.counter.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final String name;
    private final AtomicInteger value;

    public Counter() {
        this.name = "BaseCounter";
        this.value = new AtomicInteger(0);
    }

    public Counter(String name) {
        this.name = name;
        this.value = new AtomicInteger(0);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value.get();
    }

    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return Objects.equals(name, counter.name) &&
                Objects.equals(value, counter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
