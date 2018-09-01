package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "id",
        "message",
        "country",
        "sunrise",
        "sunset"
})
public class Sys {

    @JsonProperty("type")
    private Integer type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunset")
    public Integer getSunset() {
        return sunset;
    }

    public static class Builder {

        private Sys sysToBuild;

        public Builder(final Sys sys) {

            sysToBuild = new Sys();

            this.sysToBuild.type = sys.getType();
            this.sysToBuild.id = sys.getId();
            this.sysToBuild.message = sys.getMessage();
            this.sysToBuild.country = sys.getCountry();
            this.sysToBuild.sunrise = sys.getSunrise();
            this.sysToBuild.sunset = sys.getSunset();
        }

        public Sys.Builder withType(final Integer type) {
            this.sysToBuild.type = type;
            return this;
        }

        public Sys.Builder withId(final Integer id) {
            this.sysToBuild.id = id;
            return this;
        }

        public Sys.Builder withMessage(final Double message) {
            this.sysToBuild.message = message;
            return this;
        }

        public Sys.Builder withCountry(final String country) {
            this.sysToBuild.country = country;
            return this;
        }

        public Sys.Builder withSunrise(final Integer sunrise) {
            this.sysToBuild.sunrise = sunrise;
            return this;
        }

        public Sys.Builder withSunset(final Integer sunset) {
            this.sysToBuild.sunset = sunset;
            return this;
        }


        public Sys build() {
            final Sys builtSys = sysToBuild;
            sysToBuild = new Sys();
            return builtSys;
        }
    }

}
