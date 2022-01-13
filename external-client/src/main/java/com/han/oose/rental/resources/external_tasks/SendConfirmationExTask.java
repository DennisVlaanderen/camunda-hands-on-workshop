package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("send_confirmation_topic")
public class SendConfirmationExTask extends BrooksExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(SendConfirmationExTask.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "SendConfirmationDelegate");

        LOG.log(Logger.Level.INFO, "Er is een mail verstuurd naar: " + processVariables.getEmail());
        externalTaskService.complete(externalTask, processVariables.getVariables());
    }
}
