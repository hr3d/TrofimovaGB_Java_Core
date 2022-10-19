
package trofimova.javacore.lesson7;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Date",
    "Temperature",
    "Day",
    "Night"
})
@Generated("jsonschema2pojo")
public class DailyForecast {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private TemperatureForecast temperatureForecast;
    @JsonProperty("Day")
    private Day day;
    @JsonProperty("Night")
    private Night night;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Temperature")
    public TemperatureForecast getTemperatureForecast() {
        return temperatureForecast;
    }

    @JsonProperty("Temperature")
    public void setTemperatureForecast(TemperatureForecast temperatureForecast) {
        this.temperatureForecast = temperatureForecast;
    }

    @JsonProperty("Day")
    public Day getDay() {
        return day;
    }

    @JsonProperty("Day")
    public void setDay(Day day) {
        this.day = day;
    }

    @JsonProperty("Night")
    public Night getNight() {
        return night;
    }

    @JsonProperty("Night")
    public void setNight(Night night) {
        this.night = night;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
