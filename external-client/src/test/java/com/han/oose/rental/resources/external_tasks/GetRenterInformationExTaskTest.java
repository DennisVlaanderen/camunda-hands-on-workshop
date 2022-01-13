package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.domain.pojos.RenterPOJO;
import com.han.oose.rental.resources.interfaces.CheckCarCategoriesHandler;
import com.han.oose.rental.resources.interfaces.GetRenterInformationHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class GetRenterInformationExTaskTest {

    private GetRenterInformationExTask sut;

    @BeforeEach
    public void setup(){
        sut = new GetRenterInformationExTask();
    }

    @Test
    public void whenGetRenterInfoExecuteCalledWithPassingVariablesVerifyCompleteGetsExecuted() {
        RenterPOJO RENTER_POJO = new RenterPOJO(true, 30, 10 );
        int USER_ID = 1;

        ExternalTask externalTask = mock(ExternalTask.class);
        ExternalTaskService externalTaskService = mock(ExternalTaskService.class);
        CarRentalProcessVariables processVariables = mock(CarRentalProcessVariables.class);

        GetRenterInformationHandler getRenterInformationHandler = mock(GetRenterInformationHandler.class);
        sut.setGetRenterInformationHandler(getRenterInformationHandler);

        when(processVariables.getUserId()).thenReturn(USER_ID);
        when(getRenterInformationHandler.getRenterInfo(USER_ID)).thenReturn(RENTER_POJO);

        sut.execute(externalTask,externalTaskService, processVariables);

        verify(externalTaskService, times(1)).complete(any(), any());
    }
}
