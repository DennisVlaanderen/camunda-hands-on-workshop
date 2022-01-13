package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.CheckCarAvailableHandler;
import com.han.oose.rental.resources.interfaces.SaveRenterInformationHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SaveRenterInformationExTaskTest {

    private SaveRenterInformationExTask sut;

    @BeforeEach
    public void setup(){
        sut = new SaveRenterInformationExTask();
    }

    @Test
    public void whenSaveRenterInfoExecuteCalledWithPassingVariablesVerifyCompleteGetsExecuted() {
        int USER_ID = 1;
        long BIRTHDAY = 1000000;
        long DRIVERS_LICENSE_OBTAINED = 1000000;

        ExternalTask externalTask = mock(ExternalTask.class);
        ExternalTaskService externalTaskService = mock(ExternalTaskService.class);
        CarRentalProcessVariables processVariables = mock(CarRentalProcessVariables.class);

        SaveRenterInformationHandler saveRenterInformationHandler = mock(SaveRenterInformationHandler.class);
        sut.setSaveRenterInformationHandler(saveRenterInformationHandler);

        when(processVariables.getUserId()).thenReturn(USER_ID);
        when(processVariables.getBirthday()).thenReturn(BIRTHDAY);
        when(processVariables.getDriversLicenseObtained()).thenReturn(DRIVERS_LICENSE_OBTAINED);

        sut.execute(externalTask,externalTaskService, processVariables);

        verify(externalTaskService, times(1)).complete(any(), any());
    }
}
