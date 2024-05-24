package digital.softwareshinobi.projectchimba.broker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
@EnableScheduling
public class ExternalBrokerService {

    private final Logger logger = LoggerFactory.getLogger(ExternalBrokerService.class);

//    @Autowired
//    private RestTemplate restTemplate;

    //   public static final String apiBase = "http://192.168.1.4:8888";
    public static final String apiBase = "https://apis.napkinexchange.softwareshinobi.digital";

    public static final String ROBOT_ACCOUNT_NAME = "whiplashone";

    public static final String ROBOT_ACCOUNT_PASS = "forever";

    public String createTradingAccount() {

        System.out.println("enter > create-trading-account");

        String createTraderEndPoint = apiBase + "/trader/";

        System.out.println("    endpoint / " + createTraderEndPoint);

        MultiValueMap<String, String> brokerRequestMap = new LinkedMultiValueMap<>();

        Map requestHeaders = new HashMap<String, String>();

        requestHeaders.put("Content-Type", "application/json");

        brokerRequestMap.setAll(requestHeaders);

        Map requestBodyMap = new HashMap();

        requestBodyMap.put("username", ROBOT_ACCOUNT_NAME);

        requestBodyMap.put("password", ROBOT_ACCOUNT_PASS);

        HttpEntity<?> brokerHttpRequest = new HttpEntity<>(requestBodyMap, brokerRequestMap);

        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(createTraderEndPoint, brokerHttpRequest, String.class);

        System.out.println("broker response / " + brokerResponse.getBody());

        System.out.println("exit < create-trading-account");

        return "OK";

    }

    public Map detailTradingAccount() {

        String brokerEndpointURL = apiBase + "/trader/" + ROBOT_ACCOUNT_NAME;

        System.out.println("enter > detail-trading-account");

        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();

        Map requestHeaders = new HashMap<String, String>();

        requestHeaders.put("Content-Type", "application/json");

        brokerRequest.setAll(requestHeaders);

        Map requestBody = new HashMap();

        requestBody.put("username", ROBOT_ACCOUNT_NAME);

        requestBody.put("email", ROBOT_ACCOUNT_PASS);

        HttpEntity<?> brokerHttpRequest = new HttpEntity<>(requestBody, brokerRequest);

        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(brokerEndpointURL, brokerHttpRequest, Map.class);

        System.out.println("brokerResponse / " + brokerResponse.getBody());

        System.out.println("exit < detail-trading-account");

        return (Map) brokerResponse.getBody();

    }

    public List<Map> fetchSecurityPricingHistory(final String symbol) {

        String brokerEndpointURL = apiBase + "/security/history/" + symbol;

        System.out.println("enter > detail-trading-account");

         // Create a RestTemplate instance
    RestTemplate restTemplate = new RestTemplate();

    // Perform a GET request and store the response in a ResponseEntity object
    ResponseEntity<String> response = restTemplate.getForEntity(brokerEndpointURL, String.class);

    // Check the response status code
    if (response.getStatusCode().is2xxSuccessful()) {
      // Get the response body as a String
      String data = response.getBody();
      System.out.println("Response: " + data);
    } else {
      System.out.println("Error: " + response.getStatusCodeValue());
    }
//        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();
//
//        Map requestHeaders = new HashMap<String, String>();
//
//        requestHeaders.put("Content-Type", "application/json");
//
//        brokerRequest.setAll(requestHeaders);
//
//     
//        HttpEntity<?> brokerHttpRequest = new HttpEntity<>( brokerRequest);
//
//        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(brokerEndpointURL, brokerHttpRequest, Map.class);
//
//        System.out.println("brokerResponse / " + brokerResponse.getBody());
//
//        System.out.println("exit < detail-trading-account");
return null;
     //   return (List<Map>) brokerResponse.getBody();

    }

    public static Map requestSecurityLongSmartBuy(String symbol, Integer units) {

        String brokerEndpointURL = apiBase + "/broker/buy/market/smart";

        System.out.println("enter > buy-securities");

        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();

        Map requestHeaders = new HashMap<String, String>();

        requestHeaders.put("Content-Type", "application/json");

        brokerRequest.setAll(requestHeaders);

        Map requestBody = new HashMap();

        System.out.println("user / " + ROBOT_ACCOUNT_NAME);

        requestBody.put("username", ROBOT_ACCOUNT_NAME);

        requestBody.put("ticker", symbol);

        requestBody.put("sharesToBuy", units);

        HttpEntity<?> brokerHttpRequest = new HttpEntity<>(requestBody, brokerRequest);

        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(brokerEndpointURL, brokerHttpRequest, Map.class);

        System.out.println("brokerResponse / " + brokerResponse.getBody());

        System.out.println("exit < buy-securities");

        return (Map) brokerResponse.getBody();

    }

    @Bean
    public RestTemplate getRestTemplateSMA() {

        return new RestTemplate();

    }
    
}
//    //   @RequestMapping(value = "/fetch-signals")
//    private String fetchBrokerSignals() {
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        return restTemplate.exchange("https://api.napkinexchange.softwareshinobi.digital/candlestick/DIONE", HttpMethod.GET, entity, String.class).getBody();
//
//    }
//    @GetMapping("")
//    public String fetchLandingPage() {
//
//        return "The Usher Rule Trading Robot";
//
//    }
//
//    @GetMapping("/health-check")
//    public String doHealthCheck() {
//
//        return "UsherRuleTradingRobot is UP";
//
//    }
/*

        curl -X POST -H "Content-Type: application/json" -d '{"username":"SasukeReloaded","email":"linuxize@example.com"}' http://localhost:9999/trader/create


 */

 /*

        curl -X POST -H "Content-Type: application/json" -d '{"username":"SasukeReloaded","email":"linuxize@example.com"}' http://localhost:9999/trader/create


 */
//
//    public Map fundTradingAccount() {
//
//        String brokerEndpointURL = apiBase + "/trader/deposit";
//
//        System.out.println("enter > fund-trading-account");
//
//        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();
//
//        Map requestHeaders = new HashMap<String, String>();
//
//        requestHeaders.put("Content-Type", "application/json");
//
//        brokerRequest.setAll(requestHeaders);
//
//        Map requestBody = new HashMap();
//
//        requestBody.put("username", ROBOT_ACCOUNT_NAME);
//
//        requestBody.put("amountToAdd", 4_000_000);
//
//        HttpEntity<?> brokerHttpRequest = new HttpEntity<>(requestBody, brokerRequest);
//
//        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(brokerEndpointURL, brokerHttpRequest, Map.class);
//
//        System.out.println("brokerResponse / " + brokerResponse.getBody());
//
//        System.out.println("exit < fund-trading-account");
//
//        return (Map) brokerResponse.getBody();
//
//    }
