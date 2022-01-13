package com.han.oose.rental.resources.variables;

import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;

public abstract class BrooksExternalTaskHandler implements ExternalTaskHandler {

    public abstract void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables);

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        var processVariables = new CarRentalProcessVariables(externalTask);
        execute(externalTask, externalTaskService, processVariables);
    }
}