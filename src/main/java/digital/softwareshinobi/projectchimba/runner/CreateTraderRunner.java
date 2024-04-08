package digital.softwareshinobi.projectchimba.runner;

import digital.softwareshinobi.projectchimba.broker.ExternalBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CreateTraderRunner implements ApplicationRunner {

    @Autowired
    private ExternalBrokerService tradingBrokerService;

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("runner > create trading account");

        try {

            tradingBrokerService.createTradingAccount();

        } catch (Exception exception) {

            System.err.print("error creating trader" + exception);

        }

        System.out.println("runner < create trading account");

    }

}
