package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.CheckCarAvailableHandler;
import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("check_car_available_topic")
public class CheckCarAvailableExTask extends BrooksExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(CheckCarAvailableExTask.class.getName());

    @Autowired
    private CheckCarAvailableHandler checkCarAvailableHandler;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "CheckCarAvailableExTask");

        //Run business logic
        boolean isAvailable = checkCarAvailableHandler.checkCarAvailable(
                processVariables.getCarId(),
                processVariables.getRentalPeriod());

        //Set output variables
        processVariables.setCarIsAvailable(isAvailable);

        externalTaskService.complete(externalTask, processVariables.getVariables());
    }

    public void setCheckCarAvailableHandler(CheckCarAvailableHandler checkCarAvailableHandler) {
        this.checkCarAvailableHandler = checkCarAvailableHandler;
    }
}
