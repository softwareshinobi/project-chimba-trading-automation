package digital.softwareshinobi.projectpaja.usherrule.runner;

import digital.softwareshinobi.projectpaja.usherrule.service.TradingBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CreateBrokerAccountRunner implements ApplicationRunner {

    @Autowired
    private TradingBrokerService tradingBrokerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("launch > CreateBrokerAccountRunner");

        System.out.println(" > creating trading account");

        tradingBrokerService.createTradingAccount();

        System.out.println(" > fund trading account");

        tradingBrokerService.fundTradingAccount();

        System.out.println(" > detail trading account");

        tradingBrokerService.detailTradingAccount();

        System.out.println("finish < CreateBrokerAccountRunner");

    }

}
