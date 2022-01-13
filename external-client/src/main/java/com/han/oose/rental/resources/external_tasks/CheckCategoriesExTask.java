package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.CheckCarCategoriesHandler;
import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@ExternalTaskSubscription("check_categories_topic")
public class CheckCategoriesExTask extends BrooksExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(CheckCategoriesExTask.class.getName());

    @Autowired
    private CheckCarCategoriesHandler checkCategoriesHandler;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "CheckCategoriesExTask");

        boolean isAllowed = checkCategoriesHandler.isAllowedToRentCar(
                (long) processVariables.getCarId(),
                processVariables.getUserCategory());

        processVariables.setUserIsAllowedToRentCar(isAllowed);

        externalTaskService.complete(externalTask, processVariables.getVariables());
    }

    public void setCheckCategoriesHandler(CheckCarCategoriesHandler checkCategoriesHandler) {
        this.checkCategoriesHandler = checkCategoriesHandler;
    }
}
