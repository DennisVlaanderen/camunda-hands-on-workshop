package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.SaveRenterInformationHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SendConfirmationExTaskTest {

    private SendConfirmationExTask sut;

    @BeforeEach
    public void setup(){
        sut = new SendConfirmationExTask();
    }

    @Test
    public void whenSaveRenterInfoExecuteCalledWithPassingVariablesVerifyCompleteGetsExecuted() {
        ExternalTask externalTask = mock(ExternalTask.class);
        ExternalTaskService externalTaskService = mock(ExternalTaskService.class);
        CarRentalProcessVariables processVariables = mock(CarRentalProcessVariables.class);

        sut.execute(externalTask,externalTaskService, processVariables);

        verify(externalTaskService, times(1)).complete(any(), any());
    }
}
