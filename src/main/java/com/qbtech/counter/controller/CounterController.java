package com.qbtech.counter.controller;


import com.qbtech.counter.model.Counter;
import com.qbtech.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/counter")
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping(value = "/increment")
    public boolean increment() {
        return counterService.increment();
    }

    @GetMapping(value = "/counterValue")
    public int getCounterValue(String counterName) {
        return counterService.getCounterValue(counterName);
    }

    @GetMapping(value = "/getAllCounter")
    public List<Counter> getAllCounter() {
        return counterService.getAllCounter();
    }

    @PostMapping(value = "/createCounter")
    public boolean createCounter(String counterName) {
        return counterService.createCounter(counterName);
    }
}
