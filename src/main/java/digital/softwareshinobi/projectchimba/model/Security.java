package digital.softwareshinobi.projectchimba.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ticker",
    "companyName",
    "sector",
    "marketCap",
    "price",
    "lastDayPrice",
    "momentum",
    "momentumStreakInDays",
    "volatility"
})
public class Security {

    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("sector")
    private String sector;

    @JsonProperty("marketCap")
    private String marketCap;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("lastDayPrice")
    private Double lastDayPrice;

    @JsonProperty("momentum")
    private Integer momentum;

    @JsonProperty("momentumStreakInDays")
    private Integer momentumStreakInDays;

    @JsonProperty("volatility")
    private String volatility;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ticker")
    public String getTicker() {
        return ticker;
    }

    @JsonProperty("ticker")
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("sector")
    public String getSector() {
        return sector;
    }

    @JsonProperty("sector")
    public void setSector(String sector) {
        this.sector = sector;
    }

    @JsonProperty("marketCap")
    public String getMarketCap() {
        return marketCap;
    }

    @JsonProperty("marketCap")
    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("lastDayPrice")
    public Double getLastDayPrice() {
        return lastDayPrice;
    }

    @JsonProperty("lastDayPrice")
    public void setLastDayPrice(Double lastDayPrice) {
        this.lastDayPrice = lastDayPrice;
    }

    @JsonProperty("momentum")
    public Integer getMomentum() {
        return momentum;
    }

    @JsonProperty("momentum")
    public void setMomentum(Integer momentum) {
        this.momentum = momentum;
    }

    @JsonProperty("momentumStreakInDays")
    public Integer getMomentumStreakInDays() {
        return momentumStreakInDays;
    }

    @JsonProperty("momentumStreakInDays")
    public void setMomentumStreakInDays(Integer momentumStreakInDays) {
        this.momentumStreakInDays = momentumStreakInDays;
    }

    @JsonProperty("volatility")
    public String getVolatility() {
        return volatility;
    }

    @JsonProperty("volatility")
    public void setVolatility(String volatility) {
        this.volatility = volatility;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Security.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ticker");
        sb.append('=');
        sb.append(((this.ticker == null) ? "<null>" : this.ticker));
        sb.append(',');
        sb.append("companyName");
        sb.append('=');
        sb.append(((this.companyName == null) ? "<null>" : this.companyName));
        sb.append(',');
        sb.append("sector");
        sb.append('=');
        sb.append(((this.sector == null) ? "<null>" : this.sector));
        sb.append(',');
        sb.append("marketCap");
        sb.append('=');
        sb.append(((this.marketCap == null) ? "<null>" : this.marketCap));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null) ? "<null>" : this.price));
        sb.append(',');
        sb.append("lastDayPrice");
        sb.append('=');
        sb.append(((this.lastDayPrice == null) ? "<null>" : this.lastDayPrice));
        sb.append(',');
        sb.append("momentum");
        sb.append('=');
        sb.append(((this.momentum == null) ? "<null>" : this.momentum));
        sb.append(',');
        sb.append("momentumStreakInDays");
        sb.append('=');
        sb.append(((this.momentumStreakInDays == null) ? "<null>" : this.momentumStreakInDays));
        sb.append(',');
        sb.append("volatility");
        sb.append('=');
        sb.append(((this.volatility == null) ? "<null>" : this.volatility));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
