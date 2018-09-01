package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "temp",
        "pressure",
        "humidity",
        "temp_min",
        "temp_max"
})
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;

    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_max")
    public Double getTempMax() {
        return tempMax;
    }


    public static class Builder {

        private Main mainToBuild;

        public Builder(final Main main) {

            mainToBuild = new Main();

            this.mainToBuild.temp = main.getTemp();
            this.mainToBuild.pressure = main.getPressure();
            this.mainToBuild.humidity = main.getHumidity();
            this.mainToBuild.tempMin = main.getTempMin();
            this.mainToBuild.tempMax = main.getTempMax();
        }

        public Main.Builder withTemp(final Double temp) {
            this.mainToBuild.temp = temp;
            return this;
        }

        public Main.Builder withPressure(final Integer pressure) {
            this.mainToBuild.pressure = pressure;
            return this;
        }

        public Main.Builder withHumidity(final Integer humidity) {
            this.mainToBuild.humidity = humidity;
            return this;
        }

        public Main.Builder withTempMin(final Double tempMin) {
            this.mainToBuild.tempMin = tempMin;
            return this;
        }

        public Main.Builder withTempMax(final Double tempMax) {
            this.mainToBuild.tempMax = tempMax;
            return this;
        }

        public Main build() {
            final Main builtMain = mainToBuild;
            mainToBuild = new Main();
            return builtMain;
        }
    }
}
