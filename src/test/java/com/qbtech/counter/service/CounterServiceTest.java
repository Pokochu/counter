package com.qbtech.counter.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CounterServiceTest {

    public static final String SHINY_NEW_COUNTER = "shinyNewCounter";

    private CounterService counterService = new CounterService();

    @Test
    public void givenANewCreatedCounterWhenCreateNewWithSameNameThenReturnFalse() {
        //given new Counter created
        counterService.createCounter(SHINY_NEW_COUNTER);

        //when Counter with same name trying to be created again
        boolean success = counterService.createCounter(SHINY_NEW_COUNTER);

        //then success should be false
        assertFalse(success);
    }

    @Test
    public void givenAnEmptyContainerWhenGetCounterValueCalledThenItReturnsWithIntMinValue() {
        //given empty container

        //when getCounterValue called
        int counterValue = counterService.getCounterValue(SHINY_NEW_COUNTER);

        //then Integer.MIN_VALUE should be retrieved
        assertEquals(Integer.MIN_VALUE, counterValue);
    }

    @Test
    public void givenAnEmptyContainerWhenAddingNewCounterAndGetCounterValueThenReturnZeroAsItsValue() {
        //given new Counter created
        counterService.createCounter(SHINY_NEW_COUNTER);

        //when getCounterValue called
        int counterValue = counterService.getCounterValue(SHINY_NEW_COUNTER);

        //then Integer.MIN_VALUE should be retrieved
        assertEquals(0, counterValue);
    }

    @Test
    public void givenContainerWithACounterWhenIncrementCalledOnItThenItShouldIncrementItsValue() {
        //given new Counter created
        counterService.createCounter(SHINY_NEW_COUNTER);

        //when increment and getCounterValue called
        counterService.increment(SHINY_NEW_COUNTER);
        int counterValue = counterService.getCounterValue(SHINY_NEW_COUNTER);

        //then Integer.MIN_VALUE should be retrieved
        assertEquals(1, counterValue);
    }

    @Test
    public void givenEmptyContainerWhenIncrementIsCalledOnNonExistingCounterThenReturnFalse() {
        //given empty container

        //when getCounterValue called
        boolean success = counterService.increment(SHINY_NEW_COUNTER);

        //then Integer.MIN_VALUE should be retrieved
        assertFalse(success);
    }
}