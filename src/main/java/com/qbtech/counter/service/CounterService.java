package com.qbtech.counter.service;

import com.qbtech.counter.container.CounterContainer;
import com.qbtech.counter.exception.CounterNameAlreadyExistException;
import com.qbtech.counter.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CounterService {

    private static final Logger logger = LoggerFactory.getLogger(CounterService.class);

    private final CounterContainer container;

    @Autowired
    public CounterService() {
        this.container = new CounterContainer();
    }

    public boolean increment(String counterName) {
        Counter counter = container.getCounter(counterName);
        if(counter != null) {
            counter.increment();
            container.addCounter(counter);
            return true;
        }
        return false;
    }

    public int getCounterValue(String counterName) {
        Counter counter = container.getCounter(counterName);
        if(counter != null) {
            return counter.getValue();
        }
        return Integer.MIN_VALUE;
    }

    public List<Counter> getAllCounter() {
        return new ArrayList<>(container.getContainer().values());
    }

    public boolean createCounter(String counterName) {
        boolean success = false;
        try {
            container.addNewCounter(counterName);
            success = true;
        } catch (CounterNameAlreadyExistException e) {
            logger.error("Counter with name: {} already exist!", counterName);
        }
        return success;
    }
}
