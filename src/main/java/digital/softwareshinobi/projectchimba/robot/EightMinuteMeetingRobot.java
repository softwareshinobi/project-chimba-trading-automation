package digital.softwareshinobi.projectchimba.robot;

//package digital.softwareshinobi.projectchimba.robots;
//
//import digital.softwareshinobi.projectchimba.broker.ExternalBrokerService;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@CrossOrigin
//@RestController
//@RequestMapping("robots/eight-minute-meeting")
//@Configuration
//@EnableScheduling
//public class EightMinuteMeetingRobot {
//
//    private final Logger logger = LoggerFactory.getLogger(EightMinuteMeetingRobot.class);
//
//    private final List marketAnalysisReportList = new ArrayList();
//
//    private Integer countMarketEvaluations = 0;
//
//    private final Set<Integer> targetMinuteValueSet = new HashSet<>(Arrays.asList(0, 8, 16, 24, 32, 40, 48, 56));
//
//    private static final int NUMBER_UNITS_TO_BUY = 444;
//
//
//    @Scheduled(fixedRate = 1000 * 60)
//    @SuppressWarnings("unused")
//    private void performMarketAnalysis() {
//
//        logger.debug("enter > performMarketAnalysis()");
//
//        Date currentDate = new Date();
//
//        logger.debug("date / " + currentDate);
//
//        Map marketAnalyticsReport = ReportStuff(currentDate);
//
//        Map goNoGoReport = new HashMap();
//
//        goNoGoReport.put("targetMinute", targetMinuteValueSet);
//
//        goNoGoReport.put("actualMinute", currentDate.getMinutes());
//
//        Boolean doTrigger = false;
//
//        if (false) {
//            doTrigger = true;
//
//            goNoGoReport.put("description", "description description description");
//
//            executeOnTrigger();
//            //   return;
//        } else if (this.targetMinuteValueSet.contains(currentDate.getMinutes())) {
//
//            doTrigger = true;
//
//            goNoGoReport.put("description", "current minute number [" + currentDate.getMinutes() + "] and "
//                    + "target minute number  [" + this.targetMinuteValueSet + "] DO MATCH");
//
//            executeOnTrigger();
//
//        } else {
//
//            goNoGoReport.put("description", "current minute number [" + currentDate.getMinutes() + "] and "
//                    + "target minute number  [" + this.targetMinuteValueSet + "] DO NOT match");
//
//        }
//
//        marketAnalyticsReport.put("triggerJustificationReport", goNoGoReport);
//
//        marketAnalyticsReport.put("doTrigger", doTrigger);
//
//        logger.debug("executionReport" + marketAnalyticsReport);
//
//        marketAnalysisReportList.add(marketAnalyticsReport);
//
//        logger.debug("exit < performMarketAnalysis()");
//
//        countMarketEvaluations++;
//
//    }
//
//    public Map ReportStuff(Date currentDate) {
//
//        Map marketAnalysisReport = new HashMap();
//
//        ///////
//        Map trader = new HashMap();
//
//        trader.put("name", ExternalBrokerService.ROBOT_ACCOUNT_NAME);
//
//        trader.put("email", ExternalBrokerService.ROBOT_ACCOUNT_PASS);
//
//        marketAnalysisReport.put("trader", trader);
//
//        //////
//        marketAnalysisReport.put("broker", "napkin-exchange");
//
//        marketAnalysisReport.put("security", "dione");
//
//        marketAnalysisReport.put("countMarketEvaluations", countMarketEvaluations);
//
//        marketAnalysisReport.put("candle", "dione");
//
//        marketAnalysisReport.put("bid", "bid");
//
//        marketAnalysisReport.put("ask", "bid");
//
//        marketAnalysisReport.put("time", currentDate.getTime());
//
//        marketAnalysisReport.put("date", currentDate.toString());
//
//        return marketAnalysisReport;
//
//    }
//
//    private void executeOnTrigger() {
//
//        logger.debug("enter > executeOnTrigger()");
//
//        Map buySecurities = ExternalBrokerService.requestSecurityLongSmartBuy("CALLISTO", NUMBER_UNITS_TO_BUY);
//
//        ExternalBrokerService.requestSecurityLongSmartBuy("EUROPA", NUMBER_UNITS_TO_BUY);
//
//        ExternalBrokerService.requestSecurityLongSmartBuy("PANDORA", NUMBER_UNITS_TO_BUY);
//
//        ExternalBrokerService.requestSecurityLongSmartBuy("DIONE", NUMBER_UNITS_TO_BUY);
//
//        logger.debug("exit < executeOnTrigger()");
//
//        //return buySecurities;
//    }
//
//    @GetMapping("report")
//    public Map fetchMarketAnalysisReportHistory() {
//
//        Map postExecutionReport = new HashMap();
//
//        postExecutionReport.put("size", marketAnalysisReportList.size());
//
//        postExecutionReport.put("executionReports", marketAnalysisReportList);
//
//        return postExecutionReport;
//
//    }
//
//    @Bean
//    @Primary
//    public RestTemplate getRestTemplate() {
//
//        return new RestTemplate();
//
//    }
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
//}
