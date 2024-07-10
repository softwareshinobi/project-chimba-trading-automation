package digital.softwareshinobi.projectchimba.robot;

import digital.softwareshinobi.projectchimba.broker.ExternalBrokerService;
import digital.softwareshinobi.projectchimba.model.SecurityPricing;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("robot/sma")
@Configuration
@EnableScheduling
public class SimpleMovingAverageRobot {

    private final Logger logger = LoggerFactory.getLogger(SimpleMovingAverageRobot.class);

    @Autowired
    private ExternalBrokerService externalBrokerService;

    private final List marketAnalysisReportList = new ArrayList();

    private Integer countMarketEvaluations = 0;

    @Scheduled(fixedRate = 1000 * 10)
    @SuppressWarnings("unused")
    private void performMarketAnalysis() {

        System.out.println("SMA > performMarketAnalysis()");

        List<SecurityPricing> securityPricingHistory = this.externalBrokerService.feListtchSecurityPricingHistory("dione");

        if (securityPricingHistory == null) {
            System.err.println("securityPricingHistory was nullll");
            return;
        }

        System.out.println("securityPricingHistory size / " + securityPricingHistory.size());

        while (securityPricingHistory.size() > 4) {
            securityPricingHistory.remove(0);
        }

        System.out.println("securityPricingHistory size / " + securityPricingHistory.size());

        System.out.println("securityPricingHistory / " + securityPricingHistory);

        ////////////////////////////////////////////////////////
        SecurityPricing current = securityPricingHistory.remove(securityPricingHistory.size() - 1);
        double price = current.getPrice();
        ///
        double sum = 0;

        double sma = 0;

        for (SecurityPricing securityPricing : securityPricingHistory) {
            sum = sum + securityPricing.getPrice();

        }

        sma = sum / securityPricingHistory.size();

        System.out.println("sma / " + sma);
        System.out.println("price / " + price);

        ////////////////////////////////////////////////////////
        //        List<SecurityPricing> securityPricingHistory = this.externalBrokerService.feListtchSecurityPricingHistory("dione");
        ////////////////////////////////////////////////////////
        Date currentDate = new Date();

        System.out.println("date / " + currentDate);

        //
        Map marketAnalyticsReport = ReportStuff(currentDate);

        Map goNoGoReport = new HashMap();

        goNoGoReport.put("sma", sma);

        goNoGoReport.put("price", price);

        Boolean doTrigger = false;

        if (price > sma) {
            doTrigger = true;
            goNoGoReport.put("reason", "current price is ABOVE the sma(3)");

        } else {
            doTrigger = false;
            goNoGoReport.put("reason", "current price is BELOW the sma(3)");

        }

        marketAnalyticsReport.put("triggerJustificationReport", goNoGoReport);

        marketAnalyticsReport.put("trigger", doTrigger);

        System.out.println("executionReport" + marketAnalyticsReport);

        marketAnalysisReportList.add(marketAnalyticsReport);
        countMarketEvaluations++;

        if(doTrigger){
            this.executeOnTrigger(price);
        }
        
        logger.debug("exit < performMarketAnalysis()");


    }

    public Map ReportStuff(Date currentDate) {

        Map marketAnalysisReport = new HashMap();

        ///////
        Map trader = new HashMap();

        trader.put("name", externalBrokerService.ROBOT_ACCOUNT_NAME);

        trader.put("email", externalBrokerService.ROBOT_ACCOUNT_PASS);

        marketAnalysisReport.put("trader", trader);

        //////
        marketAnalysisReport.put("broker", "napkin-exchange");

        marketAnalysisReport.put("security", "dione");

        marketAnalysisReport.put("evaluations", countMarketEvaluations);

        //    marketAnalysisReport.put("candle", "dione");
        //      marketAnalysisReport.put("bid", "bid");
//        marketAnalysisReport.put("ask", "bid");
        marketAnalysisReport.put("time", currentDate.getTime());

        marketAnalysisReport.put("date", currentDate.toString());

        return marketAnalysisReport;

    }

    private void executeOnTrigger(double price) {

        logger.debug("enter > executeOnTrigger()");

        Map trader = this.externalBrokerService.detailTradingAccount();
        System.out.println("variable / trader / info /"+trader);
        
        double liquidBalance = (double) trader.get("availableFunds");
        System.out.println("variable / trader / liquidBalance /"+liquidBalance);
        
        System.out.println("variable / trader / price /"+price);

        int variableUnits = (int) (liquidBalance / price / 5);
                System.out.println("variable / trader / variableUnits /"+variableUnits);

     //   Map buySecurities = externalBrokerService.requestSecurityLongSmartBuy("CALLISTO", NUMBER_UNITS_TO_BUY);

   //     externalBrokerService.requestSecurityLongSmartBuy("EUROPA", NUMBER_UNITS_TO_BUY);

 //       externalBrokerService.requestSecurityLongSmartBuy("PANDORA", NUMBER_UNITS_TO_BUY);

        externalBrokerService.requestSecurityLongSmartBuy("DIONE", variableUnits);

        logger.debug("exit < executeOnTrigger()");

        //return buySecurities;
    }

    @GetMapping("report")
    public Map fetchMarketAnalysisReportHistory() {

        Map postExecutionReport = new HashMap();

        postExecutionReport.put("size", marketAnalysisReportList.size());

        postExecutionReport.put("executionReports", marketAnalysisReportList);

        return postExecutionReport;

    }

//    
//    
//    @GetMapping("")
//    public String landing() {
//
//        return "eight-minute-meeting";
//
//    }
//
//    @GetMapping("/health")
//    public String health() {
//
//        return "";
//
//    }
}
