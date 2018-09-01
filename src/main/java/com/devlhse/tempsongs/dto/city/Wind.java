package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speed",
        "deg"
})
public class Wind {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Integer deg;

    @JsonProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("deg")
    public Integer getDeg() {
        return deg;
    }

    public static class Builder {

        private Wind windToBuild;

        public Builder(final Wind wind) {

            windToBuild = new Wind();

            this.windToBuild.speed = wind.getSpeed();
            this.windToBuild.deg = wind.getDeg();
        }

        public Wind.Builder withSpeed(final Double speed) {
            this.windToBuild.speed = speed;
            return this;
        }

        public Wind.Builder withDeg(final Integer deg) {
            this.windToBuild.deg = deg;
            return this;
        }

        public Wind build() {
            final Wind builtWind = windToBuild;
            windToBuild = new Wind();
            return builtWind;
        }
    }
}
