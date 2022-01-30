package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.CheckCarAvailableHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CheckCarAvailableExTaskTest {

    private CheckCarAvailableExTask sut;

    @BeforeEach
    public void setup(){
        sut = new CheckCarAvailableExTask();
    }

    @Test
    public void whenCarCategoriesExecuteCalledWithPassingVariablesVerifyCompleteGetsExecuted() {
        int CAR_ID = 1;
        int RENTAL_PERIOD = 8;

        ExternalTask externalTask = mock(ExternalTask.class);
        ExternalTaskService externalTaskService = mock(ExternalTaskService.class);
        CarRentalProcessVariables processVariables = mock(CarRentalProcessVariables.class);

        CheckCarAvailableHandler checkCarAvailableHandler = mock(CheckCarAvailableHandler.class);
        sut.setCheckCarAvailableHandler(checkCarAvailableHandler);

        when(processVariables.getCarId()).thenReturn(CAR_ID);
        when(processVariables.getRentalPeriod()).thenReturn(RENTAL_PERIOD);
        when(checkCarAvailableHandler.checkCarAvailable(CAR_ID, RENTAL_PERIOD)).thenReturn(true);

        sut.execute(externalTask,externalTaskService, processVariables);

        verify(externalTaskService, times(1)).complete(any(), any());
    }
}
