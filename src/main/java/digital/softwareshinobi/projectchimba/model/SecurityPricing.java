package digital.softwareshinobi.projectchimba.model;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "security",
    "price",
    "previousprice",
    "gainPercent",
    "gainValue"
})
public class SecurityPricing {

    @JsonProperty("id")
    private Id id;
    
    @JsonProperty("security")
    private Security security;
    
    @JsonProperty("price")
    private Double price;
    
    @JsonProperty("previousprice")
    private Double previousprice;
    
    @JsonProperty("gainPercent")
    private Double gainPercent;
    
    @JsonProperty("gainValue")
    private Double gainValue;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    @JsonProperty("security")
    public Security getSecurity() {
        return security;
    }

    @JsonProperty("security")
    public void setSecurity(Security security) {
        this.security = security;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("previousprice")
    public Double getPreviousprice() {
        return previousprice;
    }

    @JsonProperty("previousprice")
    public void setPreviousprice(Double previousprice) {
        this.previousprice = previousprice;
    }

    @JsonProperty("gainPercent")
    public Double getGainPercent() {
        return gainPercent;
    }

    @JsonProperty("gainPercent")
    public void setGainPercent(Double gainPercent) {
        this.gainPercent = gainPercent;
    }

    @JsonProperty("gainValue")
    public Double getGainValue() {
        return gainValue;
    }

    @JsonProperty("gainValue")
    public void setGainValue(Double gainValue) {
        this.gainValue = gainValue;
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
        sb.append("SecurityPricing{");
        sb.append("id=").append(id);
        sb.append(", security=").append(security);
        sb.append(", price=").append(price);
        sb.append(", previousprice=").append(previousprice);
        sb.append(", gainPercent=").append(gainPercent);
        sb.append(", gainValue=").append(gainValue);
        sb.append(", additionalProperties=").append(additionalProperties);
        sb.append('}');
        return sb.toString();
    }

}
