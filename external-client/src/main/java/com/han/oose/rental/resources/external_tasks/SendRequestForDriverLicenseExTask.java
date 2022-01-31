package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
//TODO Subscribe class to correct external task
public class SendRequestForDriverLicenseExTask extends BrooksExternalTaskHandler {
    private static final Logger LOG = Logger.getLogger(SendRequestForDriverLicenseExTask.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        // TODO Log callback of class interaction
        // TODO Mock sent e-mail in logger
        // TODO Complete external task
    }
}
