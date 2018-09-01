package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "main",
        "description",
        "icon"
})
public class Weather {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("main")
    public String getMain() {
        return main;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }


    public static class Builder {

        private Weather weatherToBuild;

        public Builder(final Weather weather) {

            weatherToBuild = new Weather();

            this.weatherToBuild.id = weather.getId();
            this.weatherToBuild.main = weather.getMain();
            this.weatherToBuild.description = weather.getDescription();
            this.weatherToBuild.icon = weather.getIcon();
        }

        public Weather.Builder withId(final Integer id) {
            this.weatherToBuild.id = id;
            return this;
        }

        public Weather.Builder withMain(final String main) {
            this.weatherToBuild.main = main;
            return this;
        }

        public Weather.Builder withDescription(final String description) {
            this.weatherToBuild.description = description;
            return this;
        }

        public Weather.Builder withIcon(final String icon) {
            this.weatherToBuild.icon = icon;
            return this;
        }

        public Weather build() {
            final Weather builtWeather = weatherToBuild;
            weatherToBuild = new Weather();
            return builtWeather;
        }
    }
}