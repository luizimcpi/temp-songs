package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coord",
        "weather",
        "base",
        "main",
        "visibility",
        "wind",
        "clouds",
        "dt",
        "sys",
        "id",
        "name",
        "cod"
})
public class City {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("weather")
    private List<Weather> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("weather")
    public List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }


    public static class Builder {

        private City cityToBuild;

        public Builder(final City city) {

            cityToBuild = new City();

            this.cityToBuild.coord = city.getCoord();
            this.cityToBuild.weather = city.getWeather();
            this.cityToBuild.base = city.getBase();
            this.cityToBuild.main = city.getMain();
            this.cityToBuild.visibility = city.getVisibility();
            this.cityToBuild.wind = city.getWind();
            this.cityToBuild.clouds = city.getClouds();
            this.cityToBuild.dt = city.getDt();
            this.cityToBuild.sys = city.getSys();
            this.cityToBuild.id = city.getId();
            this.cityToBuild.name = city.getName();
            this.cityToBuild.cod = city.getCod();
        }

        public Builder withCoord(final Coord coord) {
            this.cityToBuild.coord = coord;
            return this;
        }

        public Builder withWeather(final List<Weather> weather) {
            this.cityToBuild.weather = weather;
            return this;
        }

        public Builder withBase(final String base) {
            this.cityToBuild.base = base;
            return this;
        }

        public Builder withMain(final Main main) {
            this.cityToBuild.main = main;
            return this;
        }

        public Builder withVisibility(final Integer visibility) {
            this.cityToBuild.visibility = visibility;
            return this;
        }

        public Builder withWind(final Wind wind) {
            this.cityToBuild.wind = wind;
            return this;
        }

        public Builder withClouds(final Clouds clouds) {
            this.cityToBuild.clouds = clouds;
            return this;
        }

        public Builder withDt(final Integer dt) {
            this.cityToBuild.dt = dt;
            return this;
        }

        public Builder withSys(final Sys sys) {
            this.cityToBuild.sys = sys;
            return this;
        }

        public Builder withId(final Integer id) {
            this.cityToBuild.id = id;
            return this;
        }

        public Builder withName(final String name) {
            this.cityToBuild.name = name;
            return this;
        }

        public Builder withCod(final Integer cod) {
            this.cityToBuild.cod = cod;
            return this;
        }

        public City build() {
            final City builtCity = cityToBuild;
            cityToBuild = new City();
            return builtCity;
        }

    }

}
