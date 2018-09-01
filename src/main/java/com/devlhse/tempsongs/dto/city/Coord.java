package com.devlhse.tempsongs.dto.city;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lon",
        "lat"
})
public class Coord {

    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    public static class Builder {

        private Coord coordToBuild;

        public Builder(final Coord coord) {

            coordToBuild = new Coord();

            this.coordToBuild.lon = coord.getLon();
            this.coordToBuild.lat = coord.getLat();
        }

        public Coord.Builder withLon(final Double lon) {
            this.coordToBuild.lon = lon;
            return this;
        }

        public Coord.Builder withLat(final Double lat) {
            this.coordToBuild.lat = lat;
            return this;
        }

        public Coord build() {
            final Coord builtCoord = coordToBuild;
            coordToBuild = new Coord();
            return builtCoord;
        }

    }
}
