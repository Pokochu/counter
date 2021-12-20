package com.qbtech.counter.service;

import com.qbtech.counter.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {

    private static final Logger logger = LoggerFactory.getLogger(CounterService.class);

    public boolean increment() {
        return true;
    }

    public int getCounterValue(String counterName) {
        return 0;
    }

    public List<Counter> getAllCounter() {
        return null;
    }

    public boolean createCounter(String counterName) {
        return true;
    }
}
