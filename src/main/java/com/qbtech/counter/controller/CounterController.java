package com.qbtech.counter.controller;


import com.qbtech.counter.model.Counter;
import com.qbtech.counter.service.CounterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PutMapping(value = "/increment/{counterName}")
    public @ResponseBody CounterResponse increment(@PathVariable String counterName) {
        boolean success = counterService.increment(counterName);
        return success ? new CounterResponse(success, "Counter " + counterName + "'s value was successfully incremented.")
                        : new CounterResponse(success, "There's no Counter in the container with name: " + counterName);
    }

    @GetMapping(value = "/counterValue/{counterName}")
    public @ResponseBody CounterValueResponse getCounterValue(@PathVariable String counterName) {
        int counterValue = counterService.getCounterValue(counterName);
        if(counterValue == Integer.MIN_VALUE) {
            return new CounterValueResponse(counterValue, "There's no Counter in the container with name: " + counterName);
        }
        return new CounterValueResponse(counterValue, "Successfully retrieved value.");
    }

    @GetMapping(value = "/getAllCounter", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Counter> getAllCounter() {
        return counterService.getAllCounter();
    }

    @PostMapping(value = "/createCounter/{counterName}")
    public @ResponseBody CounterResponse createCounter(@PathVariable String counterName) {
        if(StringUtils.isEmpty(counterName)) {
            return new CounterResponse(false, "Counter's name cannot be null or empty String");
        }
        boolean success = counterService.createCounter(counterName);
        return success ? new CounterResponse(success, "Successfully created new Counter: " + counterName)
                : new CounterResponse(success, "Counter with name: " + counterName + " already exist!");
    }
}
