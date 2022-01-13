package com.han.oose.rental.domain.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicResponseExceptionHandlerTest {

    private LogicResponseExceptionHandler sut;

    @BeforeEach
    public void setup() {
        this.sut = new LogicResponseExceptionHandler();
    }

    @Test
    public void testThatNullPointerThrowsAndReferenceNotFoundException(){
        assertThrows(ReferenceNotFoundException.class, () -> sut.handleNullPointer());
    }

}