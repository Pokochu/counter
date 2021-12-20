package com.qbtech.counter.container;


import com.qbtech.counter.exception.CounterNameAlreadyExistException;
import com.qbtech.counter.model.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterContainerTest {

    public static final String SHINY_NEW_COUNTER = "shinyNewCounter";

    private  CounterContainer container = new CounterContainer();

    @Test
    public void whenAddingANewCounterContainerReturnsTheCorrectNumberOfCounters() throws CounterNameAlreadyExistException {
        //given a new Counter to the empty container
        container.addNewCounter(SHINY_NEW_COUNTER);
        container.addNewCounter("shinyNewCounter2");
        container.addNewCounter("shinyNewCounter3");

        //when calling getContainer
        Map<String, Counter> counterContainer = this.container.getContainer();

        //then size should be correct
        assertEquals(3, counterContainer.size());
    }

    @Test
    public void givenAnExistingCounterWhenAddingCounterWithSameNameErrorShouldBeThrown() throws CounterNameAlreadyExistException {
        //given a new Counter to the empty container
        container.addNewCounter(SHINY_NEW_COUNTER);

        //when
        CounterNameAlreadyExistException thrown = Assertions.assertThrows(CounterNameAlreadyExistException.class, () -> {
            container.addNewCounter(SHINY_NEW_COUNTER);
        });

        assertEquals("Counter with name: shinyNewCounter already exist!", thrown.getMessage());
    }

    @Test
    public void givenACounterAddedWhenGetCounterAndIncrementItAndAddedBackToContainerThenItsValueShouldBeIncremented() throws CounterNameAlreadyExistException {
        //given a new Counter to the empty container
        container.addNewCounter(SHINY_NEW_COUNTER);

        //when get it from container and increment it
        Counter shinyNewCounter = container.getCounter(SHINY_NEW_COUNTER);
        shinyNewCounter.increment();
        //and add back to the container
        container.addCounter(shinyNewCounter);

        //then value for shinyNewCounter should be incremented
        Counter shinyNewCounterIncremented = container.getCounter(SHINY_NEW_COUNTER);

        assertEquals(1, shinyNewCounterIncremented.getValue());
    }
}