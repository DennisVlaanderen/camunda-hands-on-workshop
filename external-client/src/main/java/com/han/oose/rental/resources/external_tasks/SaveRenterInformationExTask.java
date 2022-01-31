package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.interfaces.SaveRenterInformationHandler;
import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// TODO Subscribe class to correct external task
public class SaveRenterInformationExTask extends BrooksExternalTaskHandler {
    private static final Logger LOG = Logger.getLogger(SaveRenterInformationExTask.class.getName());

    @Autowired
    private SaveRenterInformationHandler saveRenterInformationHandler;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        // TODO Log callback of class interaction
        // TODO Pass the correct variables to instance of SaveRenterInformationHandler using the saveRenterInformation method
        // TODO Complete task after calling saveRenterInformation on SaveRenterInformationHandler
    }

    public void setSaveRenterInformationHandler(SaveRenterInformationHandler saveRenterInformationHandler) {
        this.saveRenterInformationHandler = saveRenterInformationHandler;
    }
}

