package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.CheckCarAvailableHandler;
import com.han.oose.rental.resources.interfaces.CheckCarCategoriesHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CheckCategoriesExTaskTest {

    private CheckCategoriesExTask sut;

    @BeforeEach
    public void setup(){
        sut = new CheckCategoriesExTask();
    }

    @Test
    public void whenCategoriesExecuteCalledWithPassingVariablesVerifyCompleteGetsExecuted() {
        int CAR_ID = 1;
        String USER_CATEGORY = "A";

        ExternalTask externalTask = mock(ExternalTask.class);
        ExternalTaskService externalTaskService = mock(ExternalTaskService.class);
        CarRentalProcessVariables processVariables = mock(CarRentalProcessVariables.class);

        CheckCarCategoriesHandler checkCarCategoriesHandler = mock(CheckCarCategoriesHandler.class);
        sut.setCheckCategoriesHandler(checkCarCategoriesHandler);

        when(processVariables.getCarId()).thenReturn(CAR_ID);
        when(processVariables.getUserCategory()).thenReturn(USER_CATEGORY);
        when(checkCarCategoriesHandler.isAllowedToRentCar((long) CAR_ID, USER_CATEGORY)).thenReturn(true);

        sut.execute(externalTask,externalTaskService, processVariables);

        verify(externalTaskService, times(1)).complete(any(), any());
    }
}
