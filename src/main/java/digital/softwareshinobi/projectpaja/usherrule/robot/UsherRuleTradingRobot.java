package digital.softwareshinobi.projectpaja.usherrule.robot;

import digital.softwareshinobi.projectpaja.usherrule.service.TradingBrokerService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("trading-robot")
@Configuration
@EnableScheduling
public class UsherRuleTradingRobot {

    private final Logger logger = LoggerFactory.getLogger(UsherRuleTradingRobot.class);

//    @Autowired
//    private RestTemplate restTemplate;

    private final List marketAnalysisReportList = new ArrayList();

    private Integer countMarketEvaluations = 0;

    private final Integer TARGET_MINUTE = 15;

        @Bean
    public RestTemplate getRestTemplate() {
        
        return new RestTemplate();
        
    }
    @GetMapping("")
    public String fetchLandingPage() {

        return "The Usher Rule Trading Robot";

    }

    @GetMapping("/health-check")
    public String doHealthCheck() {

        return "UsherRuleTradingRobot is UP";

    }

    @Scheduled(fixedRate = 1000 * 60)
    @SuppressWarnings("unused")
    private void performMarketAnalysis() {

        System.out.println("enter > performMarketAnalysis()");

        Date currentDate = new Date();

        System.out.println("date / " + currentDate);

        Map marketAnalysisReport = ReportStuff(currentDate);

        Map triggerJustificationReport = new HashMap();

        triggerJustificationReport.put("targetMinute", TARGET_MINUTE);

        triggerJustificationReport.put("actualMinute", currentDate.getMinutes());

        Boolean doTrigger = false;

        if (currentDate.getMinutes() == this.TARGET_MINUTE) {

            doTrigger = true;

            triggerJustificationReport.put("description", "current minute number [" + currentDate.getMinutes() + "] and "
                    + "target minute number  [" + this.TARGET_MINUTE + "] DO MATCH");

            executeOnTrigger();

        } else {

            triggerJustificationReport.put("description", "current minute number [" + currentDate.getMinutes() + "] and "
                    + "target minute number  [" + this.TARGET_MINUTE + "] DO NOT match");

        }

        marketAnalysisReport.put("triggerJustificationReport", triggerJustificationReport);

        marketAnalysisReport.put("doTrigger", doTrigger);

        System.out.println("executionReport" + marketAnalysisReport);

        marketAnalysisReportList.add(marketAnalysisReport);

        System.out.println("exit < performMarketAnalysis()");

        countMarketEvaluations++;

    }

    public Map ReportStuff(Date currentDate) {

        Map marketAnalysisReport = new HashMap();

        marketAnalysisReport.put("broker", "napkin-exchange");

        marketAnalysisReport.put("security", "dione");

        marketAnalysisReport.put("countMarketEvaluations", countMarketEvaluations);

        marketAnalysisReport.put("candle", "dione");

        marketAnalysisReport.put("bid", "bid");

        marketAnalysisReport.put("ask", "bid");

        marketAnalysisReport.put("time", currentDate.getTime());

        marketAnalysisReport.put("date", currentDate.toString());

        return marketAnalysisReport;

    }

    private void executeOnTrigger() {

        System.out.println("enter > executeOnTrigger()");

        Map buySecurities = TradingBrokerService.buySecurities();

        System.out.println("exit < executeOnTrigger()");

    }

    @GetMapping("/analysis-report/")
    public Map fetchMarketAnalysisReportHistory() {

        Map postExecutionReport = new HashMap();

        postExecutionReport.put("size", marketAnalysisReportList.size());

        postExecutionReport.put("executionReports", marketAnalysisReportList);

        return postExecutionReport;

    }

}
