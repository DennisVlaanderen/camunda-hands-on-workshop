package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.domain.pojos.RenterPOJO;
import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.interfaces.GetRenterInformationHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("get_renter_information_topic")
public class GetRenterInformationExTask extends BrooksExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(GetRenterInformationExTask.class.getName());

    @Autowired
    private GetRenterInformationHandler getRenterInformationHandler;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "GetRenterInformationExTask");

        int userId = processVariables.getUserId();

        RenterPOJO renterPOJO = getRenterInformationHandler.getRenterInfo(userId);

        processVariables.setUserIsVerified(renterPOJO.isVerified());
        if (renterPOJO.isVerified()) {
            processVariables.setAge(renterPOJO.getAge());
            processVariables.setDriverLicenseAge(renterPOJO.getDriversLicenseAge());
        }

        externalTaskService.complete(externalTask, processVariables.getVariables());
    }

    public void setGetRenterInformationHandler(GetRenterInformationHandler getRenterInformationHandler) {
        this.getRenterInformationHandler = getRenterInformationHandler;
    }
}
