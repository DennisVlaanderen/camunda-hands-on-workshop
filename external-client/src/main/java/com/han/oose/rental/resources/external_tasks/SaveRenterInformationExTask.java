package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.SaveRenterInformationHandler;
import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("save_renter_information_topic")
public class SaveRenterInformationExTask extends BrooksExternalTaskHandler {
    private static final Logger LOG = Logger.getLogger(SaveRenterInformationExTask.class.getName());

    @Autowired
    private SaveRenterInformationHandler saveRenterInformationHandler;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "SaveRenterInformationExTask");

        saveRenterInformationHandler.saveRenterInformation(
                processVariables.getUserId(),
                processVariables.getBirthday(),
                processVariables.getDriversLicenseObtained());

        externalTaskService.complete(externalTask, processVariables.getVariables());
    }

    public void setSaveRenterInformationHandler(SaveRenterInformationHandler saveRenterInformationHandler) {
        this.saveRenterInformationHandler = saveRenterInformationHandler;
    }
}

