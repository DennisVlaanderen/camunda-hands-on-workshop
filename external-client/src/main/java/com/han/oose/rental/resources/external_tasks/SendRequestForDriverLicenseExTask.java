package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("send_request_for_driver_license_topic")
public class SendRequestForDriverLicenseExTask extends BrooksExternalTaskHandler {
    private static final Logger LOG = Logger.getLogger(SendRequestForDriverLicenseExTask.class.getName());

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "SendRequestDriversLicenseDelegate");
        LOG.log(Logger.Level.INFO, processVariables.getVariables());

        externalTaskService.complete(externalTask, processVariables.getVariables());
    }
}
