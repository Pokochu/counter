package com.qbtech.counter.container;

import com.qbtech.counter.exception.CounterNameAlreadyExistException;
import com.qbtech.counter.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CounterContainer {

    private static final Logger logger = LoggerFactory.getLogger(CounterContainer.class);

    private final Map<String, Counter> counterContainer;

    public CounterContainer() {
        this.counterContainer = new ConcurrentHashMap<>();
    }

    public Counter getCounter(String counterName) {
        return counterContainer.get(counterName);
    }

    public void removeCounter(String counterName) {
        counterContainer.remove(counterName);
        logger.info("Counter {} was removed from the container.", counterName);
    }

    public void addNewCounter(String counterName) throws CounterNameAlreadyExistException {
        if(counterContainer.get(counterName) != null) {
            throw new CounterNameAlreadyExistException("Counter with name: " + counterName + " already exist!");
        }
        counterContainer.put(counterName, new Counter(counterName));
        logger.info("New Counter was added: {}", counterName);
    }

    public void addCounter(Counter counter) {
        counterContainer.put(counter.getName(), counter);
        logger.info("Counter {}'s value was increased to {}.", counter.getName(), counter.getValue());
    }

    public Map<String, Counter> getContainer() {
        return counterContainer;
    }
}
