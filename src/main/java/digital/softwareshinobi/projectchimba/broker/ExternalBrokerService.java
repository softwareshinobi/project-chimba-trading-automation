package digital.softwareshinobi.projectchimba.broker;

import digital.softwareshinobi.projectchimba.model.SecurityPricing;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    public static final String apiBase = "http://192.168.1.4:8888";
  //  public static final String apiBase = "https://apis.napkinexchange.softwareshinobi.digital";

    public static final String ROBOT_ACCOUNT_NAME = "pandora";

    public static final String ROBOT_ACCOUNT_PASS = "forever";

    public String createTradingAccount() {

        System.out.println("enter > create-trading-account");

        String createTraderEndPoint = apiBase + "/trader";

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
        System.out.println("enter > detail-trading-account");

        String brokerEndpointURL = apiBase + "/trader/" + ROBOT_ACCOUNT_NAME;

        System.out.println("brokerEndpointURL " + brokerEndpointURL);

        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();

        Map requestHeaders = new HashMap<String, String>();

        requestHeaders.put("Content-Type", "application/json");

        brokerRequest.setAll(requestHeaders);

        Map requestBody = new HashMap();

        requestBody.put("username", ROBOT_ACCOUNT_NAME);

        requestBody.put("password", ROBOT_ACCOUNT_PASS);

        HttpEntity<?> brokerHttpRequest = new HttpEntity<>(requestBody, brokerRequest);

        ResponseEntity<?> brokerResponse = new RestTemplate().postForEntity(brokerEndpointURL, brokerHttpRequest, Map.class);

        System.out.println("brokerResponse / " + brokerResponse.getBody());

        System.out.println("exit < detail-trading-account");

        return (Map) brokerResponse.getBody();

    }

    public List<SecurityPricing> feListtchSecurityPricingHistory(final String symbol) {

        System.out.println("enter > fetchSecurityPricingHistory");

        String brokerEndpointURL = apiBase + "/security/history/" + symbol;

        System.out.println("brokerEndpointURL " + brokerEndpointURL);

        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<List<SecurityPricing>> rateResponse
                = restTemplate.exchange(
                        brokerEndpointURL, HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<SecurityPricing>>() {
                });
        
        List<SecurityPricing> securityPricingList = rateResponse.getBody();

     //   System.out.println("securityPricingList / " + securityPricingList);

        return securityPricingList;
    }

    public static Map requestSecurityLongSmartBuy(String symbol, Integer units) {

        String brokerEndpointURL = apiBase + "/broker/buy/smart";

        System.out.println("enter > buy-securities");

        MultiValueMap<String, String> brokerRequest = new LinkedMultiValueMap<>();

        Map requestHeaders = new HashMap<String, String>();

        requestHeaders.put("Content-Type", "application/json");

        brokerRequest.setAll(requestHeaders);

        Map requestBody = new HashMap();

        System.out.println("user / " + ROBOT_ACCOUNT_NAME);

        requestBody.put("username", ROBOT_ACCOUNT_NAME);

        requestBody.put("ticker", symbol);

        requestBody.put("units", units);

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
