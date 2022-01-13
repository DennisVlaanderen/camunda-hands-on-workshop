package com.han.oose.rental.domain.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LogicResponseExceptionHandler {

    /*
     * Use this class to catch any errors thrown in the Data layer of the application
     * Caught errors should always throw up a layer specific error that the Resource layer can act upon.
     */

    @ExceptionHandler({NullPointerException.class})
    public void handleNullPointer() throws ReferenceNotFoundException {
        throw new ReferenceNotFoundException();
    }

}
