package com.han.oose.rental.resources.external_tasks;

import com.han.oose.rental.resources.variables.BrooksExternalTaskHandler;
import com.han.oose.rental.resources.variables.CarRentalProcessVariables;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Component
@ExternalTaskSubscription("pay_deposit_topic")
public class PayDepositExTask extends BrooksExternalTaskHandler {

    private static final Logger LOG = Logger.getLogger(PayDepositExTask.class.getName());
    private Random rand = SecureRandom.getInstanceStrong();

    public PayDepositExTask() throws NoSuchAlgorithmException {
        // Do nothing because of X and Y.
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService, CarRentalProcessVariables processVariables) {
        LOG.log(Logger.Level.INFO, "PayDepositDelegate");

        int chance = rand.nextInt(3);
        float cost;

        if (chance != 0) {
            cost = rand.nextFloat();
            processVariables.setPriceTotal(cost);
            LOG.log(Logger.Level.INFO, "Price has been successfully set at: " + cost);
            externalTaskService.complete(externalTask, processVariables.getVariables());
        } else {
            LOG.log(Logger.Level.WARN, "Payment did not succeed and no price has been set.");
            externalTaskService.handleBpmnError(externalTask, "PayDepositDelegate failed to get a valid price for rental.");
        }
    }
}
